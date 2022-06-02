/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.metier.MetierCategorieProduitLocal;
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
public class ExpoLegCommercial implements ExpoLegCommercialLocal {

    @EJB
    private MetierUtilisateurLocal metierUtilisateur;

    @EJB
    private MetierProduitLocal metierProduit;

    @EJB
    private MetierCommandeLocal metierCommande;
    
    @EJB
    private MetierCategorieProduitLocal metierCategorieProduit;

    @Override
    public void creerTypeProduit(String libelle) {
        metierCategorieProduit.creerTypeProduit(libelle);
    }

    @Override
    public void supprimerTypeProduit(Long id) {
        metierCategorieProduit.supprimerTypeProduit(id);
    }

    @Override
    public void majTypeProduit(Long id, String libelle) {
        metierCategorieProduit.majTypeProduit(id, libelle);
    }

    @Override
    public List<CategorieProduit> getAllTypeProduit() {
        return metierCategorieProduit.getAllTypeProduit();
    }
   
    
}
