/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.facades.CommandeFacadeLocal;
import fr.miage.toulouse.m1.JEE.facades.ProduitFacadeLocal;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Edris
 */
@Stateless
public class MetierCommande implements MetierCommandeLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;    

    @Override
    public void creerCommande(Utilisateur u ,Map<Integer, Integer> d, Date dateCommande) {
        Map<Produit, Integer> MapProdQte = new HashMap<>();
        for(Map.Entry<Integer, Integer> p : d.entrySet()){
            MapProdQte.put(produitFacade.find(p.getKey()), p.getValue());
        }
        commandeFacade.creerCommande(u, MapProdQte, dateCommande);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    @Override
    public List<Commande> getCommandesNnLivres() {
       return commandeFacade.getCommandesNnLivres();
    }

    @Override
    public List<Commande> getCommandesLivres() {
       return commandeFacade.getCommandesLivres();
    }

    @Override
    public List<Commande> getCommandesAnnules() {
        return commandeFacade.getCommandesAnnules();
    }

    @Override
    public void setStatusCommande(Long id, Integer i) {
        commandeFacade.setStatusCommande(id, i);
    }
    
     @Override
    public void annulerCommande (Long id) {
        commandeFacade.annulerCommande(id);
    }
}
