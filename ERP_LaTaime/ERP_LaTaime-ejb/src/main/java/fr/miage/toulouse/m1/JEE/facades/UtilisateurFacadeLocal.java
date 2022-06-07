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

    public void crediterSolde(Long id, Long solde);

    public void debiterSolde(Long id, Long solde);
    
    public void creerUtilisateurClient(String nom, String prenom);

    public void creerUtilisateurLivreur(Long id, String nom, String prenom);

    public void creerUtilisateurCommercial(Long id, String nom, String prenom);
}
