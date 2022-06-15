/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.exceptions.CategorieProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface MetierCategorieProduitLocal {
    
    public List<CategorieProduit> getAllCategorieProduit();
    
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException;
    
    public void creerCategorieProduit(String libelle);
    
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException;
        
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException;
    
    public void ajouterProduitACategorieProduit(Long idQ, Long IdP) throws CategorieProduitException, ProduitException;
    
}
