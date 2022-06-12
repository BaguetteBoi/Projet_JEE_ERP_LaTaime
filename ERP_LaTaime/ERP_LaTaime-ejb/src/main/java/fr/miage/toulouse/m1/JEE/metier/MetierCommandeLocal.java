/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Edris
 */
@Local
public interface MetierCommandeLocal {
    
    
    public void creerCommande(Long idU ,Map<Integer, Integer> d, Date dateCommande) throws ProduitException;
    
    public List<Commande> getCommandesNnLivres();
    
    public List<Commande> getCommandesLivres();

    public List<Commande> getCommandesAnnules();
    
    public void setStatusCommande(Long id, Integer i);
    
    public void annulerCommande (Long id) throws ProduitException;
    
     public void demanderfacture(Long id) ;

}
