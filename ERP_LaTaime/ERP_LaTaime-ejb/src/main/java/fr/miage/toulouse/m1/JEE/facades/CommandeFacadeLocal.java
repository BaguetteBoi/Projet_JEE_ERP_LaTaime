/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
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
public interface CommandeFacadeLocal {

    void create(Commande commande);

    void edit(Commande commande);

    void remove(Commande commande);

    Commande find(Object id);

    List<Commande> findAll();

    List<Commande> findRange(int[] range);

    int count();
    
    public void creerCommande(Utilisateur u, Map d , Date dateCommande);
    
    public List<Commande> getCommandesNnLivres(List<Commande> commandes);
    
    public List<Commande> getCommandesLivres(List<Commande> commandes);

    public List<Commande> getCommandesAnnules(List<Commande> commandes);
    
    public void setStatusCommande(Long idCommande, Integer i);
    
}
