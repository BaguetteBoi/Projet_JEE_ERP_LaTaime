/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface ExpoLegLivreurLocal {
    
    public List<Commande> getCommandesNnLivres();
    
    public List<Commande> getCommandesLivres();

    public List<Commande> getCommandesAnnules();
    
    public void setStatusCommande(Long idCommande, Integer i) throws CommandeException;
}
