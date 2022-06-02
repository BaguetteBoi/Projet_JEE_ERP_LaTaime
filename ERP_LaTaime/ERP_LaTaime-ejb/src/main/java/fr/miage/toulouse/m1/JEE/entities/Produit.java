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
import javax.persistence.ManyToOne;

/**
 *
 * @author AntoineGougault
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String libelle;
    
    private Long quantite;
    
    private double prixUnitaire;
    
    private String description;
    
    @ManyToOne
    private CategorieProduit categorieProduit;

    /**
     * Get the value of categorieProduit
     *
     * @return the value of categorieProduit
     */
    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    /**
     * Set the value of categorieProduit
     *
     * @param categorieProduit new value of categorieProduit
     */
    public void setCategorieProduit(CategorieProduit categorieProduit) {
        try {
            this.categorieProduit = categorieProduit;
        }catch(Exception e){
            System.out.println("Erreur Catégorie produit : "+e);
        }
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        try {
            this.id = id;
        }catch(Exception e){
            System.out.println("Erreur id produit : "+e);
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        try {
            this.libelle = libelle;
        }catch(Exception e){
            System.out.println("Erreur libelle produit : "+e);
        }
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {       
        try {
            this.quantite = quantite;
        }catch(Exception e){
            System.out.println("Erreur quantite produit : "+e);
        }
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        try {
            this.prixUnitaire = prixUnitaire;
        }catch(Exception e){
            System.out.println("Erreur prix unitaire produit : "+e);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        try {
            this.description = description;
        }catch(Exception e){
            System.out.println("Erreur description produit : "+e);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.libelle);
        hash = 53 * hash + Objects.hashCode(this.quantite);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.prixUnitaire) ^ (Double.doubleToLongBits(this.prixUnitaire) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.description);
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
        final Produit other = (Produit) obj;
        if (Double.doubleToLongBits(this.prixUnitaire) != Double.doubleToLongBits(other.prixUnitaire)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", libele=" + libelle + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire + ", description=" + description + '}';
    }
    
}
