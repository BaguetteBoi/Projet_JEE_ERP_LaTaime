/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.facades.CommandeFacadeLocal;
import java.util.Date;
import java.util.Dictionary;
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
    private CommandeFacadeLocal commandeFacade;    

    @Override
    public void creerCommande(Utilisateur u ,Map d, Date dateCommande) {
        commandeFacade.creerCommande(u, d, dateCommande);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    @Override
    public List<Commande> getCommandesNnLivres(List<Commande> commandes) {
       return commandeFacade.getCommandesNnLivres(commandes);
    }

    @Override
    public List<Commande> getCommandesLivres(List<Commande> commandes) {
       return commandeFacade.getCommandesLivres(commandes);
    }

    @Override
    public List<Commande> getCommandesAnnules(List<Commande> commandes) {
        return commandeFacade.getCommandesAnnules(commandes);
    }

    @Override
    public void setStatusCommande(Long id, Integer i) {
        commandeFacade.setStatusCommande(id, i);
    }
}
