/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
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
/** Méthode permettant de créer un commande de produits d'un utilisateur */
    @Override
    public void creerCommande(Utilisateur u, Map d, Date dateCommande) {
        Commande commande = new Commande();
        commande.setDateCommande(dateCommande);
        commande.setListeIdProdQte(d);
        commande.setUtilisateur(u);
        this.create(commande);
    }
/**Méthode permettant de récupérer la liste des commandes non-livrés  */
    @Override
    public List<Commande> getCommandesNnLivres(List<Commande> commandes) {
        List<Commande> commNnLivres = null;
        for ( Commande commande : commandes){
            if (commande.getStatus()== Commande.StatusComm.nonLivre){
                commNnLivres.add(commande);
            }
        }
        return commNnLivres;
    }
/**Méthode permettant de récupérer la liste des commandes livrés  */
    @Override
    public List<Commande> getCommandesLivres(List<Commande> commandes) {
        List<Commande> commLivres = null;
        for ( Commande commande : commandes){
            if (commande.getStatus()== Commande.StatusComm.livre){
                commLivres.add(commande);
            }
        }
        return commLivres;
    }
    /**Méthode permettant de récupérer la liste des commandes annulés*/
    @Override
    public List<Commande> getCommandesAnnules(List<Commande> commandes) {
        List<Commande> commAnnules = null;
        for ( Commande commande : commandes){
            if (commande.getStatus()== Commande.StatusComm.annule){
                commAnnules.add(commande);
            }
        }
        return commAnnules;
    }
    /**Méthode permettant d'annuler une commande*/
     @Override
    public void annulerCommande (Long id) {
         Commande commande1 = find(id);
         commande1.setStatus(Commande.StatusComm.annule);
    }
/**Méthode permettant de changer le statut d'une commande*/
    @Override
    public void setStatusCommande(Long id, Integer i) {
        
        Commande commande = find(id);
        switch(i) {   
            case 1:
              commande.setStatus(Commande.StatusComm.livre);
              break;
            case 2:
              commande.setStatus(Commande.StatusComm.nonLivre);
              break;
            case 3:
              commande.setStatus(Commande.StatusComm.annule);
              break;
            default:
        }
        
        this.edit(commande);
    }

}
