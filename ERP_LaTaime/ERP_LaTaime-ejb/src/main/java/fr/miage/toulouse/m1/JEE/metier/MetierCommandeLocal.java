/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import java.util.Date;
import java.util.Dictionary;
import javax.ejb.Local;

/**
 *
 * @author Edris
 */
@Local
public interface MetierCommandeLocal {
    
    public void creerCommande(Long idU ,Dictionary d, Date dateCommande);
    
    public Commande getCommandeId(long idCommande);
    
    public Commande getCommandeMontant(Double montantCommande);
    
    public void setDateCommande(Commande commande, Date dateCommande);
    
}
