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

    public StatusComm status;

    private Double montantCommande;

    private Map<Produit, Integer> listeIdProdQte; // id porduit/quantite commande 

    @ManyToOne
    private Utilisateur utilisateur;

    public StatusComm getStatus() {
        return status;
    }

    public void setStatus(StatusComm s) {
        status = s;
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
        this.utilisateur = utilisateur;
    }

    public Double getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Double montantCommande) {
        this.montantCommande = montantCommande;
    }

    public Map<Produit, Integer> getListeIdProdQte() {
        return listeIdProdQte;
    }

    public void setListeIdProdQte(Map<Produit, Integer> listeIdProdQte) {
        this.listeIdProdQte = listeIdProdQte;
    }

    public void addListeIdProdQte(Produit prod, int qte) {
        this.listeIdProdQte.put(prod, qte);
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Double getMontant() {
        return montantCommande;
    }

    public void setMontant(Double montant) {
        this.montantCommande = montant;
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

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", montantCommande=" + montantCommande + '}';
    }

}
