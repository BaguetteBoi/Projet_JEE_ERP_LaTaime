/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author AdnaneElBeqqali
 */
@Local
public interface MetierUtilisateurLocal {
   public void CreerUtilisateur(String nom, String prenom);
   
   public Utilisateur getUtilisateur(Long idUtilisateur);
}
