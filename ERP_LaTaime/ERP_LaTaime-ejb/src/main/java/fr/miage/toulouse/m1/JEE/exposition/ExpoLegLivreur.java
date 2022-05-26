/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.metier.MetierCommandeLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierProduitLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierUtilisateurLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class ExpoLegLivreur implements ExpoLegLivreurLocal {
    
    @EJB
    private MetierUtilisateurLocal metierUtilisateur;

    @EJB
    private MetierProduitLocal metierProduit;

    @EJB
    private MetierCommandeLocal metierCommande;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
