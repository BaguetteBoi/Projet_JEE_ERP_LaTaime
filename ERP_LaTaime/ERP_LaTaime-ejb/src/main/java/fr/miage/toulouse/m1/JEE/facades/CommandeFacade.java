/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import static fr.miage.toulouse.m1.JEE.entities.Commande_.listeProdQte;
import static fr.miage.toulouse.m1.JEE.entities.Commande_.status;
import static fr.miage.toulouse.m1.JEE.entities.Commande_.utilisateur;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Edris
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.toulouse.m1.JEE_ERP_LaTaime-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    /**
     * Méthode permettant de créer un commande de produits d'un utilisateur
     */
    @Override
    public Commande creerCommande(Utilisateur u, Map<Produit, Integer> d, Date dateCommande, Double montant) {
        Commande commande = new Commande();
        commande.setDateCommande(dateCommande);
        commande.setListeProdQte(d);
        commande.setUtilisateur(u);
        commande.setStatus(Commande.StatusComm.nonLivrer);
        commande.setMontantCommande(montant);
        this.create(commande);
        return commande;
    }

    /**
     * Méthode permettant de récupérer la liste des commandes non-livrés
     */
    @Override
    public List<Commande> getCommandesNnLivres() {
        List<Commande> commandes = this.findAll();
        List<Commande> commNnLivres = new ArrayList<Commande>();
        for (Commande commande : commandes) {
            if (commande.getStatus() == Commande.StatusComm.nonLivrer) {
                commNnLivres.add(commande);
            }
        }
        return commNnLivres;
    }

    /**
     * Méthode permettant de récupérer la liste des commandes livrés
     */
    @Override
    public List<Commande> getCommandesLivres() {
        List<Commande> commandes = this.findAll();
        List<Commande> commLivres = new ArrayList<Commande>();
        for (Commande commande : commandes) {
            if (commande.getStatus() == Commande.StatusComm.livrer) {
                commLivres.add(commande);
            }
        }
        return commLivres;
    }

    /**
     * Méthode permettant de récupérer la liste des commandes annulés
     */
    @Override
    public List<Commande> getCommandesAnnules() {
        List<Commande> commandes = this.findAll();
        List<Commande> commAnnules = new ArrayList<Commande>();
        for (Commande commande : commandes) {
            if (commande.getStatus() == Commande.StatusComm.annule) {
                commAnnules.add(commande);
            }
        }
        return commAnnules;
    }

    /**
     * Méthode permettant d'annuler une commande
     */
    @Override
    public void annulerCommande(Long id) throws CommandeException{
        Commande commande1 = getCommande(id);
        commande1.setStatus(Commande.StatusComm.annule);
    }

    /**
     * Méthode permettant de changer le statut d'une commande
     */
    @Override
    public void setStatusCommande(Long id, Integer i) throws CommandeException{

        Commande commande = getCommande(id);
        switch (i) {
            case 0:
                commande.setStatus(Commande.StatusComm.livrer);
                break;
            case 1:
                commande.setStatus(Commande.StatusComm.nonLivrer);
                break;
            case 2:
                commande.setStatus(Commande.StatusComm.annule);
                break;
            default:
        }

        this.edit(commande);
    }

    /**
     * Méthode permettant de générer la facture d'une commande
     * @param id
     * @return
     * @throws CommandeException
     */
    @Override
    public String facturer(Long id) throws CommandeException{

        String qteProd = "";
        Commande commande = getCommande(id);

        for (int i = 0; i < commande.getListeProdQte().size(); i++) {
            qteProd += commande.getListeProdQte().get(i) + "\n";
        }
        if (commande.getStatus() != Commande.StatusComm.annule) {
            return "Client = " + utilisateur
                    + "Id commande = " + commande.getIdCommande()
                    + "\n Date de la commande = " + commande.getDateCommande()
                    + "\n Status de la commande = " + status
                    + "\n Montant = " + commande.getMontantCommande()
                    + "\n Liste des produits et quantités = " + qteProd;
        } else {
            return "Commande Annulée";
        }
    }

    /**
     * Méthode permettant de récupérer une commande
     * @param id
     * @return
     * @throws CommandeException
     */
    @Override
    public Commande getCommande(Long id) throws CommandeException{
        Commande c = this.find(id);
        if (c != null) {
            return c;
        } else {
            throw new CommandeException("Id Commande " + id + " inconnue");
        }
    }
    
    

}
