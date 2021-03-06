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
    private Utilisateur creerUtilisateur(String nom, String prenom, TypeU typeU) {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setType(typeU);
        user.setSolde(0D);
        this.create(user);
        return user;
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
    public Double getStatutSoldeCompte(Long id) throws UtilisateurException {
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
    public void crediterSolde(Long id, Double solde) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        Double currentsolde = user.getSolde();
        Double totsolde = solde + currentsolde;
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
    public void debiterSolde(Long id, Double solde) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        Double currentsolde = user.getSolde();
        Double totsolde = currentsolde - solde;
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
    public Utilisateur creerUtilisateurClient(String nom, String prenom) {
        return creerUtilisateur(nom, prenom, TypeU.Client);
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
    public Utilisateur creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);

        if (user.getType() == Utilisateur.TypeU.Admin || user.getType() == Utilisateur.TypeU.Commercial) {
            return creerUtilisateur(nom, prenom, TypeU.Commercial);
        }else{
            throw new UtilisateurException("L'Utilisateur ID=" + id + "n'a pas les droits nécessaire pour créer ce type d'utilisateur");
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
    public Utilisateur creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        if (user.getType() == Utilisateur.TypeU.Admin || user.getType() == Utilisateur.TypeU.Commercial) {
            return creerUtilisateur(nom, prenom, TypeU.Livreur);
        }else{
            throw new UtilisateurException("L'Utilisateur ID=" + id + "n'a pas les droits nécessaire pour créer ce type d'utilisateur");
        }
    }

    /**
     * Méthode permettant de récupérer un utilisateur
     * @param id
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Utilisateur getUtilisateur(Long id) throws UtilisateurException {
        Utilisateur u = this.find(id);
        if (u != null) {
            return u;
        } else {
            throw new UtilisateurException("Id Utilisateur " + id + " inconnue");
        }
    }

    /**
     * Méthode permettant de récupérer le numéro de compte de la Miage (compte admin)
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Long getMiageCompteBancaire() throws UtilisateurException {
        try {
            return getCompteAdmin().getNumCompteBancaire();
        } catch (UtilisateurException ex) {
            return creerUtilisateurAdmin().getNumCompteBancaire();
        }
    }

    /**
     * Méthode permettant de configurer le numéro de compte de la Miage (compte admin)
     *
     * Méthode permettant de @param num
     * @throws UtilisateurException
     */
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

    /**
     * Méthode permettant de créer l'utilisateur admin
     * @return
     */
    @Override
    public Utilisateur creerUtilisateurAdmin() {

        try {
            getCompteAdmin();
            throw new UtilisateurException("Le compte Utilisateur Admin est déjà créé");
        } catch (UtilisateurException ex) {
            Utilisateur user = new Utilisateur();
            user.setNom("Admin");
            user.setPrenom("LaTaime");
            user.setSolde(0D);
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

    /**
     * Méthode permettant de configurer le numéro de compte bancaire d'un utilisateur
     * @param id
     * @param num
     * @throws UtilisateurException
     */
    @Override
    public void setUtilisateurCompteBancaire(Long id, Long num) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        user.setNumCompteBancaire(num);
        this.edit(user);
    }

    /**
     * Méthode permettant d'ajouter une commande à un utilisateur
     * @param id
     * @param c
     * @throws UtilisateurException
     */
    @Override
    public void addCommande(Long id, Commande c) throws UtilisateurException {
        Utilisateur user = getUtilisateur(id);
        user.addCommande(c);
        this.edit(user);
    }
}
