/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
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
    public Produit getProduit(long id) throws ProduitException{
        return produitFacade.getProduit(id);
    }

    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) throws ProduitException{
        produitFacade.setPrixUnitaire(id, prixUnitaire);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitFacade.getAllProduits();
    }

    @Override
    public void setQuantite(long id, int quantite) throws ProduitException{
        produitFacade.setQuantite(id, quantite);
    }

    @Override
    public void supprimerProduit(long id) throws ProduitException{
        produitFacade.supprimerProduit(id);
    }

    @Override
    public void modifierProduit(long id, String libele, String description) throws ProduitException{
        produitFacade.modifierProduit(id, libele, description);
    }

    @Override
    public boolean isProduitEnStock(long id) throws ProduitException{
        return produitFacade.isProduitEnStock(id);
    }

}
