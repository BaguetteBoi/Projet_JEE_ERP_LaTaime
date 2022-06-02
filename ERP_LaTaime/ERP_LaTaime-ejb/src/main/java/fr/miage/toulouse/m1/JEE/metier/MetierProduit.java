/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.facades.ProduitFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class MetierProduit implements MetierProduitLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;

    @Override
    public void creerProduit(String libele, double prixUnitaire, String description) {
        produitFacade.creerProduit(libele, prixUnitaire, description);
    }

    @Override
    public Produit getProduit(long id) {
        return produitFacade.getProduit(id);
    }

    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) {
        produitFacade.setPrixUnitaire(id, prixUnitaire);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitFacade.getAllProduits();
    }

    @Override
    public void setQuantite(long id, long quantite) {
        produitFacade.setQuantite(id, quantite);
    }

    @Override
    public void supprimerProduit(long id) {
        produitFacade.supprimerProduit(id);
    }

    @Override
    public void modifierProduit(long id, String libele, String description) {
        produitFacade.modifierProduit(id, libele, description);
    }

    @Override
    public boolean isProduitEnStock(long id) {
        return produitFacade.isProduitEnStock(id);
    }

}
