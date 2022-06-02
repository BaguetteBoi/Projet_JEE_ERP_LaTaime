/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();
    
    public void creerProduit(String libele, double prixUnitaire, String description);
        
    public Produit getProduit(long id);
    
    public List<Produit> getAllProduit();
    
    public void setQuantite(long id, long prixUnitaire);
       
    public void setPrixUnitaire(long id, double prixUnitaire);
    
    public void supprimerProduit(long id);
    
    public void modifierProduit(long id, String libele, String description);
    
    public boolean isProduitEnStock(long id);
}
