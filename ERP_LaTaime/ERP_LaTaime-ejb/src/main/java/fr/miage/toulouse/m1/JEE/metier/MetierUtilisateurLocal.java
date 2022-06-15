/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AdnaneElBeqqali
 */
@Local
public interface MetierUtilisateurLocal {

    public Utilisateur getUtilisateur(Long idUtilisateur) throws UtilisateurException;
    // Partie d'ajout de commandes au métier de l'utilisateur 

    public List<Commande> getCommandes(Long id) throws UtilisateurException;

    public void crediterSolde(Long id, Double solde) throws UtilisateurException;

    public void debiterSolde(Long id, Double solde) throws UtilisateurException;

    public Utilisateur creerUtilisateurClient(String nom, String prenom);

    public Utilisateur creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException;

    public Utilisateur creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException;
    
    public void statutsolde(Long id) throws UtilisateurException;
        
    public Double getStatutSoldeCompte(Long id) throws UtilisateurException;
        
    public Long getMiageCompteBancaire() throws UtilisateurException;
    
    public void setMiageCompteBancaire(Long num) throws UtilisateurException;
    
    public void setUtilisateurCompteBancaire(Long id, Long num) throws UtilisateurException;
    
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException;
}
