/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur.TypeU;
import java.util.List;
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
    
    /**Méthode permettant de créer un nouvel utilisateur. On va faire appel à cette méthode afin de pouvoir créer tout type d'utilisateurs. */
    private void creerUtilisateur(String nom, String prenom, TypeU typeU) {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setType(typeU);
        this.create(user);
    }

    /**Méthode permettant de récupérer l'ensemble des commandes crées par l'utilisateur clie
     * @param id
     * @param idn
     * @return */
    @Override
    public List<Commande> getCommandes(Long id) {
        Utilisateur user = this.find(id);
        return user.getCommandes();

    }
    
    /** Fonction permettant de récupérer le solde d'un utilisateur */
    @Override
    public Long getStatutSoldeCompte(Long id) {
        Utilisateur user = this.find(id);
        return user.getSolde();
    }

    /**Méthode permettant de créditer le solde de l'utilisateur client
     * @param id
     * @param solde */
    @Override
    public void crediterSolde(Long id, Long solde) {
        Utilisateur user = this.find(id);
        try {
            Long currentsolde = user.getSolde();
            Long totsolde = solde + currentsolde;
            user.setSolde(totsolde);
        } catch (Exception e) {
            System.out.println("Erreur le solde à créditer est invalide");
        }
    }

    /**Méthode permettant de débiter le solde de l'utilisateur client
     * @param id
     * @param solde */
    @Override
    public void debiterSolde(Long id, Long solde) {
        Utilisateur user = this.find(id);
        try {
            Long currentsolde = user.getSolde();
            Long totsolde = currentsolde - solde;
            if (totsolde >= 0) {
                user.setSolde(totsolde);
            }
        } catch (Exception e) {
            System.out.println("Solde insuffisant veuillez créditer votre compte");
        }
    }
    
    /**Méthode permettant de créer un utilisateur Client
     * @param nom
     * @param prenom */
    @Override
    public void creerUtilisateurClient(String nom, String prenom) {
        creerUtilisateur(nom, prenom, TypeU.Client);
    }

    /**Méthode permettant de créer un utilisateur Commercial
     * @param id
     * @param nom
     * @param prenom */
    @Override
    public void creerUtilisateurCommercial(Long id, String nom, String prenom) {
        Utilisateur user = this.find(id);

        if (user.getType() == Utilisateur.TypeU.Admin) {
            creerUtilisateur(nom, prenom, TypeU.Commercial);
        }
    }
    
    /**Méthode permettant de créer un utilisateur Livreur
     * @param id
     * @param nom
     * @param prenom */
    @Override
    public void creerUtilisateurLivreur(Long id, String nom, String prenom) {
        Utilisateur user = this.find(id);
        if (user.getType() == Utilisateur.TypeU.Admin || user.getType() == Utilisateur.TypeU.Commercial) {
            creerUtilisateur(nom, prenom, TypeU.Livreur);
        }
    }

    @Override
    public Long getMiageCompteBancaire() {
        return getCompteAdmin().getNumCompteBancaire();
    }

    @Override
    public void setMiageCompteBancaire(Long num) {
        Utilisateur u = getCompteAdmin();
        u.setNumCompteBancaire(num);
        this.edit(u);
    }

    public Utilisateur creerUtilisateurAdmin() {
        Utilisateur user = new Utilisateur();
        user.setNom("Admin");
        user.setPrenom("LaTaime");
        user.setType(TypeU.Admin);
        this.create(user);
        return user;
    }
    
    private Utilisateur getCompteAdmin(){
        List<Utilisateur> allU = this.findAll();
        for(Utilisateur u : allU){
            if(u.getType() == TypeU.Admin)
                return u;
        }
        
        return creerUtilisateurAdmin();
    }

}
