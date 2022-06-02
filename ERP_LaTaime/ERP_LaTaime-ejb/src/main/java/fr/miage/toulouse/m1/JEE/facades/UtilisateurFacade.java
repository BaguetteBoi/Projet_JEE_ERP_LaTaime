/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
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

    @Override
    public void creerUtilisateur(String nom, String prenom) {
        Utilisateur user = new Utilisateur();
        user.setNom(nom);
        user.setPrenom(prenom);
        this.create(user);
    }

    @Override
    public List<Commande> getCommandes(Long id) {
        Utilisateur user = this.find(id);
        return user.getCommandes();

    }

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
    
    @Override
    public void debiterSolde(Long id, Long solde) {
        Utilisateur user = this.find(id);
        try {
            Long currentsolde = user.getSolde();
            Long totsolde = currentsolde - solde;
            if (totsolde>=0)
            { 
            user.setSolde(totsolde);
            }
        } catch (Exception e) {
            System.out.println("Solde insuffisant veuillez créditer votre compte");
        }
    }

}
