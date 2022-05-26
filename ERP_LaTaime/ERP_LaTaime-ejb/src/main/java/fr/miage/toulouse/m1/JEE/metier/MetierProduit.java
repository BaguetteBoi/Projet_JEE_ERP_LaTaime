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
        return produitFacade.find(id);
    }

    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) {
        Produit p = getProduit(id);
        p.setPrixUnitaire(prixUnitaire);
        produitFacade.edit(p);
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitFacade.findAll();
    }

    @Override
    public void setQuantite(long id, long quantite) {
        Produit p = getProduit(id);
        p.setQuantite(quantite);
        produitFacade.edit(p);
    }

    @Override
    public void supprimerProduit(long id) {
        produitFacade.remove(getProduit(id));
    }

    @Override
    public void modifierProduit(long id, String libele, String description) {
        Produit p = getProduit(id);
        
        if (!libele.isEmpty()) {
            p.setLibele(libele);
        }
        if (!description.isEmpty()) {
            p.setDescription(description);
        }
        
        if (!libele.isEmpty() || !description.isEmpty()) {
            produitFacade.edit(p);
        }
    }

    @Override
    public boolean isProduitEnStock(long id) {
        return (getProduit(id).getQuantite() > 0);
    }

}
