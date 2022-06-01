/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author AntoineGougault
 */
@Entity
public class CategorieProduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String libelle;
    
    @OneToMany
    private List<Produit> produits;

    /**
     * Get the value of produits
     *
     * @return the value of produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Set the value of produits
     *
     * @param produits new value of produits
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    /**
     * Add the value of produit
     *
     * @param produit new value of produits
     */
    public void addProduit(Produit produit) {
        this.produits.add(produit);
    }


    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the value of libelle
     *
     * @param libelle new value of libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieProduit)) {
            return false;
        }
        CategorieProduit other = (CategorieProduit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.toulouse.m1.JEE.entities.TypeProduit[ id=" + id + " ]";
    }
    
}
