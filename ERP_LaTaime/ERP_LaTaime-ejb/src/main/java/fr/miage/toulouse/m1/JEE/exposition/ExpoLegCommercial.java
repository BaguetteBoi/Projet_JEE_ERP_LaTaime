/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CategorieProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import fr.miage.toulouse.m1.JEE.metier.MetierCategorieProduitLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierCommandeLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierProduitLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierUtilisateurLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class ExpoLegCommercial implements ExpoLegCommercialLocal {

    @EJB
    private MetierUtilisateurLocal metierUtilisateur;

    @EJB
    private MetierProduitLocal metierProduit;

    @EJB
    private MetierCommandeLocal metierCommande;

    @EJB
    private MetierCategorieProduitLocal metierCategorieProduit;

    @Override
    public void creerCategorieProduit(String libelle) {
        metierCategorieProduit.creerCategorieProduit(libelle);
    }

    @Override
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException{
        metierCategorieProduit.supprimerCategorieProduit(id);
    }

    @Override
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException{
        metierCategorieProduit.majCategorieProduit(id, libelle);
    }
    
    @Override
    public void ajouterProduitACategorieProduit(Long idQ, Long IdP) throws CategorieProduitException, ProduitException {
        metierCategorieProduit.ajouterProduitACategorieProduit(idQ, IdP);
    }

    @Override
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException {
        return metierCategorieProduit.getCategorieProduit(id);
    }

    @Override
    public List<CategorieProduit> getAllCategorieProduit() {
        return metierCategorieProduit.getAllCategorieProduit();
    }

    @Override
    public void creerProduit(String libele, double prixUnitaire, String description) {
        metierProduit.creerProduit(libele, prixUnitaire, description);
    }

    @Override
    public Produit getProduit(long id) throws ProduitException {
        return metierProduit.getProduit(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return metierProduit.getAllProduits();
    }

    @Override
    public void setQuantite(long id, long prixUnitaire) throws ProduitException {
        metierProduit.setQuantite(id, prixUnitaire);
    }

    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) throws ProduitException {
        metierProduit.setPrixUnitaire(id, prixUnitaire);
    }

    @Override
    public void supprimerProduit(long id) throws ProduitException {
        metierProduit.supprimerProduit(id);
    }

    @Override
    public void modifierProduit(long id, String libele, String description) throws ProduitException {
        metierProduit.modifierProduit(id, libele, description);
    }

    @Override
    public boolean isProduitEnStock(long id) throws ProduitException {
        return metierProduit.isProduitEnStock(id);
    }

    @Override
    public Utilisateur creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException {
        return this.metierUtilisateur.creerUtilisateurCommercial(id, nom, prenom);
    }

    @Override
    public Utilisateur creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException {
        return this.metierUtilisateur.creerUtilisateurLivreur(id, nom, prenom);
    }

    @Override
    public Long getMiageCompteBancaire() throws UtilisateurException {
        return metierUtilisateur.getMiageCompteBancaire();
    }

    @Override
    public void setMiageCompteBancaire(Long num) throws UtilisateurException {
        metierUtilisateur.setMiageCompteBancaire(num);
    }

    @Override
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException {
        return metierUtilisateur.creerUtilisateurAdmin();
    }
}
