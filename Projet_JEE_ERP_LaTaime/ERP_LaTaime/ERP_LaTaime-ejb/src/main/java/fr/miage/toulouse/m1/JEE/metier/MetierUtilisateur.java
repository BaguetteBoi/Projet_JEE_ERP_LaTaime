/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.facades.UtilisateurFacadeLocal;
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
    public void CreerUtilisateur(String nom, String prenom) {
        this.utilisateurFacade.creerUtilisateur(nom, prenom);
        }

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) {
        return this.utilisateurFacade.find(idUtilisateur);
          }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
