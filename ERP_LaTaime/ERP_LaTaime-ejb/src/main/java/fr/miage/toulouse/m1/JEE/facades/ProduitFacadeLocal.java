/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
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
        
    public Produit getProduit(long id) throws ProduitException;
    
    public List<Produit> getAllProduits();
    
    public void setQuantite(long id, int prixUnitaire) throws ProduitException;
       
    public void setPrixUnitaire(long id, double prixUnitaire) throws ProduitException;
    
    public void supprimerProduit(long id) throws ProduitException;
    
    public void modifierProduit(long id, String libele, String description) throws ProduitException;
    
    public boolean isProduitEnStock(long id) throws ProduitException;
}
