/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.toulouse.m1.JEE_ERP_LaTaime-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }

    @Override
    public void creerProduit(String libele, double prixUnitaire, String description) {
        Produit produit = new Produit();
        produit.setLibelle(libele);
        produit.setPrixUnitaire(prixUnitaire);
        produit.setDescription(description);
        this.create(produit);
    }

    @Override
    public Produit getProduit(long id) {
        return this.find(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        List<Produit> lp = findAll();
        return lp;
    }

    @Override
    public void setQuantite(long id, long quantite) {
        Produit p = find(id);
        p.setQuantite(quantite);
        this.edit(p);

    }

    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) {
        Produit p = find(id);
        p.setPrixUnitaire(prixUnitaire);
        this.edit(p);
    }

    @Override
    public void supprimerProduit(long id) {
        Produit p = find(id);
        this.remove(p);
    }

    @Override
    public void modifierProduit(long id, String libelle, String description) {
        Produit p = getProduit(id);
        
        if (!libelle.isEmpty()) {
            p.setLibelle(libelle);
        }
        if (!description.isEmpty()) {
            p.setDescription(description);
        }
        
        if (!libelle.isEmpty() || !description.isEmpty()) {
            this.edit(p);
        }
    }

    @Override
    public boolean isProduitEnStock(long id) {
        Produit p = find(id);
        return p.getQuantite()>0;
    }
    
}
