/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface ExpoLegCommercialLocal {

    public void creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException;

    public void creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException;

    //crud categories (type prod)
    public void creerTypeProduit(String libelle);

    public void supprimerTypeProduit(Long id);

    public void majTypeProduit(Long id, String libelle);

    public List<CategorieProduit> getAllTypeProduit();

    //Produit
    public void creerProduit(String libele, double prixUnitaire, String description);

    public Produit getProduit(long id) throws ProduitException;

    public List<Produit> getAllProduits();

    public void setQuantite(long id, long prixUnitaire) throws ProduitException;

    public void setPrixUnitaire(long id, double prixUnitaire) throws ProduitException;

    public void supprimerProduit(long id) throws ProduitException;

    public void modifierProduit(long id, String libele, String description) throws ProduitException;

    public boolean isProduitEnStock(long id) throws ProduitException;
    
    public Long getMiageCompteBancaire() throws UtilisateurException;
    
    public void setMiageCompteBancaire(Long num) throws UtilisateurException;
    
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException;
}
