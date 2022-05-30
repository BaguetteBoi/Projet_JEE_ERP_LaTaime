/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import java.util.Date;
import java.util.Dictionary;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Edris
 */
@Local
public interface MetierCommandeLocal {
    
    
    public void creerCommande(Utilisateur u ,Map d, Date dateCommande);
    
    public Commande getCommandeId();
    
    public Commande setCommandeId(long idCommande);
    
    public Commande getCommandeMontant();
    
    public Commande setCommandeMontant(Commande commande, Double montantCommande);
    
    public void setDateCommande(Commande commande, Date dateCommande);
    
    public void getDateCommande();

}
