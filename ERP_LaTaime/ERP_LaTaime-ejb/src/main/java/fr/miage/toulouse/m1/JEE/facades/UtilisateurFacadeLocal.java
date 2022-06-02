/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AdnaneElBeqqali
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
    public List<Commande> getCommandes(Long id);
    
    public void creerUtilisateur( String nom, String prenom);
    
    public void crediterSolde(Long id, Long solde);
    
     public void debiterSolde(Long id, Long solde);
     
     public void creerUtilisateurLivreur(String nom, String prenom);
     
     public void creerUtilisateurCommercial(String nom, String prenom);
}
