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
        livre, nonLivre, annule;
    }

    private StatusComm status;

    private Double montantCommande;

    private Map<Produit, Integer> listeIdProdQte; // id porduit/quantite commande 

    @ManyToOne
    private Utilisateur utilisateur;

    public StatusComm getStatus() {
        return status;
    }

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

    public Double getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Double montantCommande) {
        try {
            this.montantCommande = montantCommande;
        }catch(Exception e){
            System.out.println("Erreur Montant commande : "+e);
        }
    }

    public Map<Produit, Integer> getListeIdProdQte() {
        return listeIdProdQte;
    }

    public void setListeIdProdQte(Map<Produit, Integer> listeIdProdQte) {
        try {
            this.listeIdProdQte = listeIdProdQte;
        }catch(Exception e){
            System.out.println("Erreur setListeIdProdQte commande : "+e);
        }
    }
    
    public void addProduitAndQteToListe(Produit p, Integer qte) {
        try {
            if(this.listeIdProdQte == null){
                this.listeIdProdQte = new HashMap<Produit, Integer>();
            }
            this.listeIdProdQte.put(p, qte);
        }catch(Exception e){
            System.out.println("Erreur setListeIdProdQte commande : "+e);
        }
    }

    public void addListeIdProdQte(Produit prod, int qte) {
        try {
            this.listeIdProdQte.put(prod, qte);
        }catch(Exception e){
            System.out.println("Erreur addListeIdProdQte commande : "+e);
        }
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        try {
            this.idCommande = idCommande;
        }catch(Exception e){
            System.out.println("Erreur setIdCommande commande : "+e);
        }
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        try {
            this.dateCommande = dateCommande;
        }catch(Exception e){
            System.out.println("Erreur date commande : "+e);
        }
    }

    public Double getMontant() {
        return montantCommande;
    }
    
 

    public void setMontant(Double montant) {
        try {
            this.montantCommande = montant;
        }catch(Exception e){
            System.out.println("Erreur Montant commande : "+e);
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

    /** Méthode Facturer, qui permet de retourner une facture dès que le statut 
     * de la commande est validé (différent de annulé) */
    public String facturer() {
        
        String qteProd = "";
        
        for (int i = 0; i<listeIdProdQte.size();i++){
            qteProd += listeIdProdQte.get(i)+"\n";
        }
        if (status!= status.annule){
            return  "Client = " + utilisateur +
                "Id commande = " + idCommande +
                "\n Date de la commande = " + dateCommande +
                "\n Status de la commande = " + status +
                "\n Montant = " + montantCommande+
                "\n Liste des produits et quantités = " + qteProd;
        }else{
            return "Commande Annulée";
        }
    }
    

}
