/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *Classe Utilisateur qui définit l'utilisateur avec tous ces attributs.
 * Cette classe comprend aussi la liste des produits qui sont attribués au même utilisateur.
 * 
 * @author AdnaneElBeqqali
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private TypeU type;
    
    private long numCompteBancaire;

    private Double solde;
    @OneToMany
    private List<Commande> commandes;


    public Utilisateur() {
    }

    /**
     * Get the value of nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     * @param nom
     */
    public void setNom(String nom) {  
        try {
            this.nom = nom;
        }catch(Exception e){
            System.out.println("Erreur Nom Utilisateur : "+e);
        }
    }

    /**
     * Get the value of prenom
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        try {
            this.prenom = prenom;
        }catch(Exception e){
            System.out.println("Erreur Prenom Utilisateur : "+e);
        }
    }

    /**
     * Get the value of type
     * @return
     */
    public TypeU getType() {
        return type;
    }

    /**
     * Set the value of type
     * @param type
     */
    public void setType(TypeU type) {
        try {
            this.type = type;
        }catch(Exception e){
            System.out.println("Erreur Type Utilisateur : "+e);
        }
    }

    /**
     * Get the value of id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     * @param id
     */
    public void setId(Long id) {
        try {
            this.id = id;
        }catch(Exception e){
            System.out.println("Erreur ID Utilisateur : "+e);
        }
    }
    
    /**
     * Get the value of solde
     * @return
     */
    public Double getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     * @param solde
     */
    public void setSolde(Double solde) {
        this.solde = solde;
    }

    /**
     * Get the value of numCompteBancaire
     *
     * @return the value of numCompteBancaire
     */
    public long getNumCompteBancaire() {
        return numCompteBancaire;
    }

    /**
     * Set the value of numCompteBancaire
     *
     * @param numCompteBancaire new value of numCompteBancaire
     */
    public void setNumCompteBancaire(long numCompteBancaire) {
        this.numCompteBancaire = numCompteBancaire;
    }   
    
    /**
     * Get the value of commande
     *
     * @return the value of commande
     */
    public List<Commande> getCommandes() {
        return commandes;
        
    }

    /**
     * Set the value of commande
     *
     * @param commandes new value of commande
     */
    public void setCommande(List<Commande> commandes) {
        try {
            this.commandes = commandes;
        }catch(Exception e){
            System.out.println("Erreur Commandes Utilisateur : "+e);
        }
    }
    
    /**
     * Add the value of commande
     *
     * @param commande new value of commande
     */
    public void addCommande(Commande commande) {
        try {
            this.commandes.add(commande);
        }catch(Exception e){
            System.out.println("Erreur ajout commande Utilisateur : "+e);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prenom);
        hash = 97 * hash + Objects.hashCode(this.type);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type + ", numCompteBancaire=" + numCompteBancaire + ", solde=" + solde + '}';
    }

    
    /** La classe TypeU définit le type de l'utilisateur.
     * Un utilisateur peut être un client, un commercial, un livreur ou un et un seul Admin qui possède le compte de laTaime 
     * 
     */
    public enum TypeU{
        Client, Commercial, Livreur, Admin
    }
}
