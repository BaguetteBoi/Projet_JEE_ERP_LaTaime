/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Dictionary;
import javax.persistence.ManyToOne;

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
    
    private Date dateCommande;
    
    private Double montantCommande;
    
    private Dictionary <Long,Integer> listeIdProdQte; // id porduit/quantite commande 
    
    private Long idU;
    
    @ManyToOne
    private Utilisateur utilisateur;

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


    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }
    
    

    public Double getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Double montantCommande) {
        this.montantCommande = montantCommande;
    }

    public Dictionary<Long, Integer> getListeIdProdQte() {
        return listeIdProdQte;
    }

    public void setListeIdProdQte(Dictionary<Long, Integer> listeIdProdQte) {
        this.listeIdProdQte = listeIdProdQte;
    }
    
    public Long getId() {
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
