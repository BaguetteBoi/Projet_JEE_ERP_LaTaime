/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur.TypeU;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AdnaneElBeqqali
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.toulouse.m1.JEE_ERP_LaTaime-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    /**
     * Méthode permettant de créer un nouvel utilisateur. On va faire appel à
     * cette méthode afin de pouvoir créer tout type d'utilisateurs.
     */
    private void creerUtilisateur(String nom, String prenom, TypeU typeU) {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setType(typeU);
        user.setSolde(0L);
        this.create(user);
    }

    /**
     * Méthode permettant de récupérer l'ensemble des commandes crées par
     * l'utilisateur clie
     *
     * @param id
     * @return
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public List<Commande> getCommandes(Long id) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        return user.getCommandes();

    }

    /**
     * Fonction permettant de récupérer le solde d'un utilisateur
     *
     * @param id
     * @return
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public Long getStatutSoldeCompte(Long id) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        return user.getSolde();
    }

    /**
     * Méthode permettant de créditer le solde de l'utilisateur client
     *
     * @param id
     * @param solde
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public void crediterSolde(Long id, Long solde) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        Long currentsolde = user.getSolde();
        Long totsolde = solde + currentsolde;
        user.setSolde(totsolde);
        this.edit(user);
    }

    /**
     * Méthode permettant de débiter le solde de l'utilisateur client
     *
     * @param id
     * @param solde
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public void debiterSolde(Long id, Long solde) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        Long currentsolde = user.getSolde();
        Long totsolde = currentsolde - solde;
        if (totsolde >= 0) {
            user.setSolde(totsolde);
            this.edit(user);
        }else{
            throw new UtilisateurException("Solde insuffisant veuillez créditer votre compte ");
        }
    }

    /**
     * Méthode permettant de créer un utilisateur Client
     *
     * @param nom
     * @param prenom
     */
    @Override
    public void creerUtilisateurClient(String nom, String prenom) {
        creerUtilisateur(nom, prenom, TypeU.Client);
    }

    /**
     * Méthode permettant de créer un utilisateur Commercial
     *
     * @param id
     * @param nom
     * @param prenom
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public void creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);

        if (user.getType() == Utilisateur.TypeU.Admin || user.getType() == Utilisateur.TypeU.Commercial) {
            creerUtilisateur(nom, prenom, TypeU.Commercial);
        }
    }

    /**
     * Méthode permettant de créer un utilisateur Livreur
     *
     * @param id
     * @param nom
     * @param prenom
     * @throws fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException
     */
    @Override
    public void creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        if (user.getType() == Utilisateur.TypeU.Admin || user.getType() == Utilisateur.TypeU.Commercial) {
            creerUtilisateur(nom, prenom, TypeU.Livreur);
        }
    }

    @Override
    public Utilisateur getUtilisateur(Long id) throws UtilisateurException {
        Utilisateur u = this.find(id);
        if (u != null) {
            return u;
        } else {
            throw new UtilisateurException("Id Utilisateur " + id + " inconnue");
        }
    }

    @Override
    public Long getMiageCompteBancaire() throws UtilisateurException {
        try {
            return getCompteAdmin().getNumCompteBancaire();
        } catch (UtilisateurException ex) {
            return creerUtilisateurAdmin().getNumCompteBancaire();
        }
    }

    @Override
    public void setMiageCompteBancaire(Long num) throws UtilisateurException {
        Utilisateur u;
        try {
            u = getCompteAdmin();
        } catch (UtilisateurException ex) {
            u = creerUtilisateurAdmin();
        }
        u.setNumCompteBancaire(num);
        this.edit(u);
    }

    @Override
    public Utilisateur creerUtilisateurAdmin() {

        try {
            getCompteAdmin();
            throw new UtilisateurException("Le compte Utilisateur Admin est déjà créé");
        } catch (UtilisateurException ex) {
            Utilisateur user = new Utilisateur();
            user.setNom("Admin");
            user.setPrenom("LaTaime");
            user.setSolde(0L);
            user.setType(TypeU.Admin);
            user.setNumCompteBancaire(2);
            this.create(user);
            return user;
        }
    }

    private Utilisateur getCompteAdmin() throws UtilisateurException {
        List<Utilisateur> allU = this.findAll();
        for (Utilisateur u : allU) {
            if (u.getType() == TypeU.Admin) {
                return u;
            }
        }

        throw new UtilisateurException("Le compte Utilisateur Admin n'existe pas");
    }

    @Override
    public void setUtilisateurCompteBancaire(Long id, Long num) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        user.setNumCompteBancaire(num);
        this.edit(user);
    }
}
