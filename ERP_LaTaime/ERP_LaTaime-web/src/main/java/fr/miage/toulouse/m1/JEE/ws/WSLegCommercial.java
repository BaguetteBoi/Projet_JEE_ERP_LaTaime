/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CategorieProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import fr.miage.toulouse.m1.JEE.exposition.ExpoLegCommercialLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author AdnaneElBeqqali
 */
@WebService(serviceName = "WSLegCommercial")
public class WSLegCommercial {

    @EJB
    private ExpoLegCommercialLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    /**
     * Methode webservice permettant de créer une catégories de produit
     * @param libelle
     */
    @WebMethod(operationName = "creerCategorieProduit")
    public void creerCategorieProduit(@WebParam(name = "libelle") String libelle) {
        ejbRef.creerCategorieProduit(libelle);
    }

    /**
     * Methode webservice permettant de supprimer une catégories de produit
     * @param id
     * @throws CategorieProduitException
     */
    @WebMethod(operationName = "supprimerCategorieProduit")
    public void supprimerCategorieProduit(@WebParam(name = "id") String id) throws CategorieProduitException {
        Long idp = Long.parseLong(id);
        ejbRef.supprimerCategorieProduit(idp);
    }

    /**
     * Methode webservice permettant de modifier le libelle d'une catégories de produit
     * @param id
     * @param libelle
     * @throws CategorieProduitException
     */
    @WebMethod(operationName = "majCategorieProduit")
    public void majCategorieProduit(@WebParam(name = "id") String id, @WebParam(name = "libelle") String libelle) throws CategorieProduitException {
        Long idp = Long.parseLong(id);
        ejbRef.majCategorieProduit(idp, libelle);
    }

    /**
     * Methode webservice permettant de récupérer toutes les catégories de produit et leurs produits rattaché
     * @return
     */
    @WebMethod(operationName = "getAllCategorieProduit")
    public List<CategorieProduit> getAllCategorieProduit() {
        return ejbRef.getAllCategorieProduit();
    }
    
    /**
     * Methode webservice permettant d'ajouter un produit à une categorie de produit
     * @param idQ
     * @param idP
     * @throws CategorieProduitException
     * @throws ProduitException
     */
    @WebMethod(operationName = "ajouterProduitACategorieProduit")
    public void ajouterProduitACategorieProduit(@WebParam(name = "idQ") String idQ, @WebParam(name = "IdP") String idP) throws CategorieProduitException, ProduitException {
        Long idq = Long.parseLong(idQ);
        Long idp = Long.parseLong(idP);
        ejbRef.ajouterProduitACategorieProduit(idq, idp);
    }

    /**
     * Methode webservice permettant de récupérer une catégorie de produit et ses produits rattaché
     * @param id
     * @return
     * @throws CategorieProduitException
     */
    @WebMethod(operationName = "getCategorieProduit")
    public CategorieProduit getCategorieProduit(@WebParam(name = "id") String id) throws CategorieProduitException {
        Long idQ = Long.parseLong(id);
        return ejbRef.getCategorieProduit(idQ);
    }

    /**
     * Methode webservice permettant de créer un produit
     * @param libele
     * @param prixUnitaire
     * @param description
     */
    @WebMethod(operationName = "creerProduit")
    public void creerProduit(@WebParam(name = "libele") String libele, @WebParam(name = "prixUnitaire") String prixUnitaire, @WebParam(name = "description") String description) {
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.creerProduit(libele, prxu, description);
    }

    /**
     * Methode webservice permettant de récupérer un produit par son id
     * @param id
     * @return
     * @throws ProduitException
     */
    @WebMethod(operationName = "getProduit")
    public Produit getProduit(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        return ejbRef.getProduit(idp);
    }

    /**
     * Methode webservice permettant de récupérer tous les produits
     * @return
     */
    @WebMethod(operationName = "getAllProduits")
    public List<Produit> getAllProduits() {
        return ejbRef.getAllProduits();
    }

    /**
     * Methode webservice permettant de configurer la quantiter d'un produit
     * @param id
     * @param prixUnitaire
     * @throws ProduitException
     */
    @WebMethod(operationName = "setQuantite")
    public void setQuantite(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) throws ProduitException{
        Long idp = Long.parseLong(id);
        int pru = Integer.parseInt(prixUnitaire);
        ejbRef.setQuantite(idp, pru);
    }

    /**
     * Methode webservice permettant de configurer le prix unitaire d'un produit
     * @param id
     * @param prixUnitaire
     * @throws ProduitException
     */
    @WebMethod(operationName = "setPrixUnitaire")
    public void setPrixUnitaire(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) throws ProduitException{
        Long idp = Long.parseLong(id);
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.setPrixUnitaire(idp, prxu);
    }

    /**
     * Methode webservice permettant de supprimer un produit
     * @param id
     * @throws ProduitException
     */
    @WebMethod(operationName = "supprimerProduit")
    public void supprimerProduit(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        ejbRef.supprimerProduit(idp);
    }

    /**
     * Methode webservice permettant de modifier les propriété d'un produit
     * @param id
     * @param libele
     * @param description
     * @throws ProduitException
     */
    @WebMethod(operationName = "modifierProduit")
    public void modifierProduit(@WebParam(name = "id") String id, @WebParam(name = "libele") String libele, @WebParam(name = "description") String description) throws ProduitException{
        Long idp = Long.parseLong(id);
        ejbRef.modifierProduit(idp, libele, description);
    }

    /**
     * Methode webservice permettant de demander si un produit est en stock
     * @param id
     * @return
     * @throws ProduitException
     */
    @WebMethod(operationName = "isProduitEnStock")
    public boolean isProduitEnStock(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        return ejbRef.isProduitEnStock(idp);
    }
    
    /**
     * Methode webservice permettant de créer un utilisateur de type "Commercial"
     * @param id
     * @param nom
     * @param prenom
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "creerUtilisateurCommercial")
    public Utilisateur creerUtilisateurCommercial(@WebParam(name = "id") String id, @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) throws UtilisateurException {
        Long idp = Long.parseLong(id);
        return ejbRef.creerUtilisateurCommercial(idp, nom, prenom);
    } 
    
    /**
     * Methode webservice permettant de créer un utilisateur de type "Livreur"
     * @param id
     * @param nom
     * @param prenom
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "creerUtilisateurLivreur")
    public Utilisateur creerUtilisateurLivreur(@WebParam(name = "id") String id, @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) throws UtilisateurException {
        Long idp = Long.parseLong(id);
        return ejbRef.creerUtilisateurLivreur(idp, nom, prenom);
    }
    
    /**
     * Methode webservice permettant de récupérer le numéro de compte bancaire de la miage (utilisateur admin) sur l'erp
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "getMiageCompteBancaire")
    public Long getMiageCompteBancaire() throws UtilisateurException {
        return ejbRef.getMiageCompteBancaire();
    }

    /**
     * Methode webservice permettant de configurer le compte bancaire de la miage (utilisateur admin) sur l'erp
     * @param num
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "setMiageCompteBancaire")
    public void setMiageCompteBancaire(@WebParam(name = "num") String num) throws UtilisateurException {
        Long numC = Long.parseLong(num);
        ejbRef.setMiageCompteBancaire(numC);
    }

    /**
     * Methode webservice permettant créer l'utilisateur admin
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "creerUtilisateurAdmin")
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException {
        return ejbRef.creerUtilisateurAdmin();
    }
}
