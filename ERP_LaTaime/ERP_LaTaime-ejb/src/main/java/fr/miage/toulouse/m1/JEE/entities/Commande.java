/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.entities;

import fr.miage.toulouse.m1.JEE.entities.Commande.StatusComm;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Edris
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idCommande;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCommande;

    public enum StatusComm {
        livrer, nonLivrer, annule;
    }

    private StatusComm status;

    private Double montantCommande;

    private Map<Produit, Integer> listeProdQte; // porduit/quantite commande 

    @ManyToOne
    private Utilisateur utilisateur;

    /**
     * Get the value of status
     * @return
     */
    public StatusComm getStatus() {
        return status;
    }

    /**
     * Set the value of status
     * @param s
     */
    public void setStatus(StatusComm s) {
        try {
            status = s;
        }catch(Exception e){
            System.out.println("Erreur Status commande : "+e);
        }
        
    }

    /**
     * Get the value of utilisateur
     *
     * @return the value of utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Set the value of utilisateur
     *
     * @param utilisateur new value of utilisateur
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        
        try {
            this.utilisateur = utilisateur;
        }catch(Exception e){
            System.out.println("Erreur setUtilisateur commande : "+e);
        }
    }

    /**
     * Get the value of montantCommande
     * @return
     */
    public Double getMontantCommande() {
        return montantCommande;
    }

    /**
     * Set the value of montantCommande
     * @param montantCommande
     */
    public void setMontantCommande(Double montantCommande) {
        try {
            this.montantCommande = montantCommande;
        }catch(Exception e){
            System.out.println("Erreur Montant commande : "+e);
        }
    }

    /**
     * Get the value of listeProdQte
     * @return
     */
    public Map<Produit, Integer> getListeProdQte() {
        return listeProdQte;
    }

    /**
     * Set the value of listeProdQte
     * @param listeProdQte
     */
    public void setListeProdQte(Map<Produit, Integer> listeProdQte) {
        try {
            this.listeProdQte = listeProdQte;
        }catch(Exception e){
            System.out.println("Erreur setListeIdProdQte commande : "+e);
        }
    }
    
    /**
     * Ajoute un produit et une quantit?? ?? la liste de produit de la commande
     * @param p
     * @param qte
     */
    public void addProduitAndQteToListe(Produit p, Integer qte) {
        try {
            if(this.listeProdQte == null){
                this.listeProdQte = new HashMap<Produit, Integer>();
            }
            this.listeProdQte.put(p, qte);
        }catch(Exception e){
            System.out.println("Erreur setListeIdProdQte commande : "+e);
        }
    }

    /**
     * Get the value of setIdCommande
     * @return
     */
    public Long getIdCommande() {
        return idCommande;
    }

    /**
     * Set the value of setIdCommande
     * @param idCommande
     */
    public void setIdCommande(Long idCommande) {
        try {
            this.idCommande = idCommande;
        }catch(Exception e){
            System.out.println("Erreur setIdCommande commande : "+e);
        }
    }

    /**
     * Get the value of dateCommande
     * @return
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Set the value of dateCommande
     * @param dateCommande
     */
    public void setDateCommande(Date dateCommande) {
        try {
            this.dateCommande = dateCommande;
        }catch(Exception e){
            System.out.println("Erreur date commande : "+e);
        }
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idCommande);
        hash = 59 * hash + Objects.hashCode(this.dateCommande);
        hash = 59 * hash + Objects.hashCode(this.montantCommande);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commande other = (Commande) obj;
        if (!Objects.equals(this.idCommande, other.idCommande)) {
            return false;
        }
        if (!Objects.equals(this.dateCommande, other.dateCommande)) {
            return false;
        }
        if (!Objects.equals(this.montantCommande, other.montantCommande)) {
            return false;
        }
        return true;
    }

    /** M??thode Facturer, qui permet de retourner une facture d??s que le statut 
     * de la commande est valid?? (diff??rent de annul??) */
    public String facturer() {
        
        String qteProd = "";
        
        for (int i = 0; i<listeProdQte.size();i++){
            qteProd += listeProdQte.get(i)+"\n";
        }
        if (status!= status.annule){
            return  "Client = " + utilisateur +
                "Id commande = " + idCommande +
                "\n Date de la commande = " + dateCommande +
                "\n Status de la commande = " + status +
                "\n Montant = " + montantCommande+
                "\n Liste des produits et quantit??s = " + qteProd;
        }else{
            return "Commande Annul??e";
        }
    }
    

}
