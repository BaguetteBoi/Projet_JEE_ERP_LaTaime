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
import fr.miage.toulouse.m1.JEE.facades.UtilisateurFacadeLocal;
import fr.miage.toulouse.m1.JEE.utility.ClientRest;
import java.util.Date;
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

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @Override
    public void creerCommande(Long idU, Map<Integer, Integer> d, Date dateCommande) {

        Utilisateur client = utilisateurFacade.find(idU);
        ClientRest.CallVirementMiageBank(client.getNumCompteBancaire(), utilisateurFacade.getMiageCompteBancaire(), Long.MIN_VALUE);

        Map<Produit, Integer> MapProdQte = new HashMap<>();
        for (Map.Entry<Integer, Integer> p : d.entrySet()) {
            MapProdQte.put(produitFacade.find(p.getKey()), p.getValue());
        }
        commandeFacade.creerCommande(client, MapProdQte, dateCommande);
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
    public void annulerCommande(Long id) {
        Commande commande1 = commandeFacade.find(id);

        commande1.setStatus(Commande.StatusComm.annule);
        for (Map.Entry<Produit, Integer> p : commande1.getListeIdProdQte().entrySet()) {
            produitFacade.setQuantite(p.getKey().getId(), p.getKey().getQuantite() - p.getValue());
        }

    }

    @Override
    public void demanderfacture(Long id) {
        commandeFacade.facturer(id);
    }
}
