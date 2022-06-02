/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface MetierCategorieProduitLocal {
    
    public List<CategorieProduit> getAllTypeProduit();
    
    public CategorieProduit getTypeProduit(Long id);
    
    public void creerTypeProduit(String libelle);
    
    public void supprimerTypeProduit(Long id);
        
    public void majTypeProduit(Long id, String libelle);
    
}
