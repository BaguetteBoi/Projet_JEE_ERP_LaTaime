/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.metier.MetierCommandeLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierProduitLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierUtilisateurLocal;
import java.util.List;
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


    @Override
    public List<Commande> getCommandesNnLivres(List<Commande> commandes) {
       return metierCommande.getCommandesNnLivres(commandes);   
    }

    @Override
    public List<Commande> getCommandesLivres(List<Commande> commandes) {
        return metierCommande.getCommandesLivres(commandes);
    }

    @Override
    public List<Commande> getCommandesAnnules(List<Commande> commandes) {
        return metierCommande.getCommandesAnnules(commandes);
    }

    @Override
    public void setStatusCommande(Long idCommande, Integer i) {
        metierCommande.setStatusCommande(idCommande, i);
    }
}
