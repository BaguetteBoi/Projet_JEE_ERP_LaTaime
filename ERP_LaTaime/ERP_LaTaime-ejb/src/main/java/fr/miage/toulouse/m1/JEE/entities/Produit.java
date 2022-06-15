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


/**Classe définissant le produit avec toutes ses spécifications liés 
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

    /** Méthode pour récupérer l'ID d'un produit */
    public Long getId() {
        return id;
    }

      /** Méthode pour définir l'ID d'un produit */
    public void setId(Long id) {
        try {
            this.id = id;
        }catch(Exception e){
            System.out.println("Erreur id produit : "+e);
        }
    }
  /** Méthode pour récupérer le libelle d'un produit */
    public String getLibelle() {
        return libelle;
    }
  /** Méthode pour définir le libelle d'un produit */
    public void setLibelle(String libelle) {
        try {
            this.libelle = libelle;
        }catch(Exception e){
            System.out.println("Erreur libelle produit : "+e);
        }
    }
  /** Méthode pour récupérer la quantité d'un produit */
    public Long getQuantite() {
        return quantite;
    }
/** Méthode pour définir la quantité d'un produit */
    public void setQuantite(Long quantite) {       
        try {
            this.quantite = quantite;
        }catch(Exception e){
            System.out.println("Erreur quantite produit : "+e);
        }
    }
  /** Méthode pour récupérer le prix unitaire d'un produit */
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
        return "Produit{" + "id=" + id + ", libelle=" + libelle + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire + ", description=" + description + '}';
    }
    
}
