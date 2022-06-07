/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.facades.UtilisateurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AdnaneElBeqqali
 */
@Stateless
public class MetierUtilisateur implements MetierUtilisateurLocal {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) {
        return this.utilisateurFacade.find(idUtilisateur);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Commande> getCommandes(Long id) {

        return this.utilisateurFacade.getCommandes(id);
    }
    
    @Override
    public void crediterSolde(Long id, Long solde){
        this.utilisateurFacade.crediterSolde(id, solde);
    }
    
    @Override
     public void debiterSolde(Long id, Long solde){
         this.utilisateurFacade.debiterSolde(id, solde);
     }
     
     @Override
     public void creerUtilisateurClient(String nom, String prenom){
         this.utilisateurFacade.creerUtilisateurClient(nom, prenom);
     }
     
     @Override
     public void creerUtilisateurCommercial(Long id, String nom, String prenom){
         this.utilisateurFacade.creerUtilisateurCommercial(id, nom, prenom);
     }
     
     @Override
     public void creerUtilisateurLivreur(Long id, String nom, String prenom){
         this.utilisateurFacade.creerUtilisateurLivreur(id, nom, prenom);
     }
}
