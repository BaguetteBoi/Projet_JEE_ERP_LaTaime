/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Produit;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface MetierProduitLocal {
    
    public void creerProduit(String libele, double prixUnitaire, String description);
    
    public Produit getProduit(long id);
    
    public Produit getProduit(String libele);
    
    public void setPrixUnitaire(Produit produit, double prixUnitaire);
}
