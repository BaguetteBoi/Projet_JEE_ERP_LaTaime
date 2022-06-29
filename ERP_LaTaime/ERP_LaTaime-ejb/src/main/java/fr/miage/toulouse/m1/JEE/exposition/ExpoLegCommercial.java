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
    private MetierCategorieProduitLocal metierCategorieProduit;

    /**
     *
     * @param libelle
     */
    @Override
    public void creerCategorieProduit(String libelle) {
        metierCategorieProduit.creerCategorieProduit(libelle);
    }

    /**
     *
     * @param id
     * @throws CategorieProduitException
     */
    @Override
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException{
        metierCategorieProduit.supprimerCategorieProduit(id);
    }

    /**
     *
     * @param id
     * @param libelle
     * @throws CategorieProduitException
     */
    @Override
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException{
        metierCategorieProduit.majCategorieProduit(id, libelle);
    }
    
    /**
     *
     * @param idQ
     * @param IdP
     * @throws CategorieProduitException
     * @throws ProduitException
     */
    @Override
    public void ajouterProduitACategorieProduit(Long idQ, Long IdP) throws CategorieProduitException, ProduitException {
        metierCategorieProduit.ajouterProduitACategorieProduit(idQ, IdP);
    }

    /**
     *
     * @param id
     * @return
     * @throws CategorieProduitException
     */
    @Override
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException {
        return metierCategorieProduit.getCategorieProduit(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<CategorieProduit> getAllCategorieProduit() {
        return metierCategorieProduit.getAllCategorieProduit();
    }

    /**
     *
     * @param libele
     * @param prixUnitaire
     * @param description
     */
    @Override
    public void creerProduit(String libele, double prixUnitaire, String description) {
        metierProduit.creerProduit(libele, prixUnitaire, description);
    }

    /**
     *
     * @param id
     * @return
     * @throws ProduitException
     */
    @Override
    public Produit getProduit(long id) throws ProduitException {
        return metierProduit.getProduit(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Produit> getAllProduits() {
        return metierProduit.getAllProduits();
    }

    /**
     *
     * @param id
     * @param prixUnitaire
     * @throws ProduitException
     */
    @Override
    public void setQuantite(long id, int prixUnitaire) throws ProduitException {
        metierProduit.setQuantite(id, prixUnitaire);
    }

    /**
     *
     * @param id
     * @param prixUnitaire
     * @throws ProduitException
     */
    @Override
    public void setPrixUnitaire(long id, double prixUnitaire) throws ProduitException {
        metierProduit.setPrixUnitaire(id, prixUnitaire);
    }

    /**
     *
     * @param id
     * @throws ProduitException
     */
    @Override
    public void supprimerProduit(long id) throws ProduitException {
        metierProduit.supprimerProduit(id);
    }

    /**
     *
     * @param id
     * @param libele
     * @param description
     * @throws ProduitException
     */
    @Override
    public void modifierProduit(long id, String libele, String description) throws ProduitException {
        metierProduit.modifierProduit(id, libele, description);
    }

    /**
     *
     * @param id
     * @return
     * @throws ProduitException
     */
    @Override
    public boolean isProduitEnStock(long id) throws ProduitException {
        return metierProduit.isProduitEnStock(id);
    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Utilisateur creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException {
        return this.metierUtilisateur.creerUtilisateurCommercial(id, nom, prenom);
    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Utilisateur creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException {
        return this.metierUtilisateur.creerUtilisateurLivreur(id, nom, prenom);
    }

    /**
     *
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Long getMiageCompteBancaire() throws UtilisateurException {
        return metierUtilisateur.getMiageCompteBancaire();
    }

    /**
     *
     * @param num
     * @throws UtilisateurException
     */
    @Override
    public void setMiageCompteBancaire(Long num) throws UtilisateurException {
        metierUtilisateur.setMiageCompteBancaire(num);
    }

    /**
     *
     * @return
     * @throws UtilisateurException
     */
    @Override
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException {
        return metierUtilisateur.creerUtilisateurAdmin();
    }
}
