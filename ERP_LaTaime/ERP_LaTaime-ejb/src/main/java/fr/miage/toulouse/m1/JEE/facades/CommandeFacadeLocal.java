/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
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
    
    public Commande creerCommande(Utilisateur u, Map<Produit, Integer> d , Date dateCommande, Double montant);
    
    public List<Commande> getCommandesNnLivres();
    
    public List<Commande> getCommandesLivres();

    public List<Commande> getCommandesAnnules();
    
    public void setStatusCommande(Long id, Integer i) throws CommandeException;
    
    public void annulerCommande(Long id) throws CommandeException;
    
    public Commande getCommande(Long id)throws CommandeException;
    
    public String facturer(Long id) throws CommandeException;
    
}
