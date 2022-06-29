/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import fr.miage.toulouse.m1.JEE.facades.CommandeFacadeLocal;
import fr.miage.toulouse.m1.JEE.facades.ProduitFacadeLocal;
import fr.miage.toulouse.m1.JEE.facades.UtilisateurFacadeLocal;
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

    /**
     *
     * @param idU
     * @param d
     * @param dateCommande
     * @throws ProduitException
     * @throws UtilisateurException
     */
    @Override
    public void creerCommande(Long idU, Map<Integer, Integer> d, Date dateCommande) throws ProduitException, UtilisateurException{

        Utilisateur client = utilisateurFacade.find(idU);
        Double montantC = 0d;
        
        Map<Produit, Integer> MapProdQte = new HashMap<>();
        for (Map.Entry<Integer, Integer> p : d.entrySet()) {
            MapProdQte.put(produitFacade.getProduit(p.getKey()), p.getValue());
        }
        
        for(Map.Entry<Produit, Integer> p : MapProdQte.entrySet()){
            montantC += ( p.getKey().getPrixUnitaire() * p.getValue() );
        }
        
        utilisateurFacade.debiterSolde(idU, montantC);
        Commande c = commandeFacade.creerCommande(client, MapProdQte, dateCommande, montantC);
        utilisateurFacade.addCommande(idU, c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     *
     * @return
     */
    @Override
    public List<Commande> getCommandesNnLivres() {
        return commandeFacade.getCommandesNnLivres();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Commande> getCommandesLivres() {
        return commandeFacade.getCommandesLivres();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Commande> getCommandesAnnules() {
        return commandeFacade.getCommandesAnnules();
    }

    /**
     *
     * @param id
     * @param i
     * @throws CommandeException
     */
    @Override
    public void setStatusCommande(Long id, Integer i) throws CommandeException{
        commandeFacade.setStatusCommande(id, i);
    }

    /**
     *
     * @param id
     * @throws ProduitException
     * @throws CommandeException
     */
    @Override
    public void annulerCommande(Long id) throws ProduitException, CommandeException{
        Commande commande1 = commandeFacade.getCommande(id);

        commande1.setStatus(Commande.StatusComm.annule);
        for (Map.Entry<Produit, Integer> p : commande1.getListeProdQte().entrySet()) {
            produitFacade.setQuantite(p.getKey().getId(), p.getKey().getQuantite() - p.getValue());
        }

    }

    /**
     *
     * @param id
     * @return
     * @throws CommandeException
     */
    @Override
    public String demanderfacture(Long id) throws CommandeException{
        return commandeFacade.facturer(id);
    }
}
