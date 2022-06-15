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

    @WebMethod(operationName = "creerCategorieProduit")
    public void creerCategorieProduit(@WebParam(name = "libelle") String libelle) {
        ejbRef.creerCategorieProduit(libelle);
    }

    @WebMethod(operationName = "supprimerCategorieProduit")
    public void supprimerCategorieProduit(@WebParam(name = "id") String id) throws CategorieProduitException {
        Long idp = Long.parseLong(id);
        ejbRef.supprimerCategorieProduit(idp);
    }

    @WebMethod(operationName = "majCategorieProduit")
    public void majCategorieProduit(@WebParam(name = "id") String id, @WebParam(name = "libelle") String libelle) throws CategorieProduitException {
        Long idp = Long.parseLong(id);
        ejbRef.majCategorieProduit(idp, libelle);
    }

    @WebMethod(operationName = "getAllCategorieProduit")
    public List<CategorieProduit> getAllCategorieProduit() {
        return ejbRef.getAllCategorieProduit();
    }
    
    @WebMethod(operationName = "ajouterProduitACategorieProduit")
    public void ajouterProduitACategorieProduit(@WebParam(name = "idQ") String idQ, @WebParam(name = "IdP") String idP) throws CategorieProduitException, ProduitException {
        Long idq = Long.parseLong(idQ);
        Long idp = Long.parseLong(idP);
        ejbRef.ajouterProduitACategorieProduit(idq, idp);
    }

    @WebMethod(operationName = "getCategorieProduit")
    public CategorieProduit getCategorieProduit(@WebParam(name = "id") String id) throws CategorieProduitException {
        Long idQ = Long.parseLong(id);
        return ejbRef.getCategorieProduit(idQ);
    }

    @WebMethod(operationName = "creerProduit")
    public void creerProduit(@WebParam(name = "libele") String libele, @WebParam(name = "prixUnitaire") String prixUnitaire, @WebParam(name = "description") String description) {
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.creerProduit(libele, prxu, description);
    }

    @WebMethod(operationName = "getProduit")
    public Produit getProduit(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        return ejbRef.getProduit(idp);
    }

    @WebMethod(operationName = "getAllProduits")
    public List<Produit> getAllProduits() {
        return ejbRef.getAllProduits();
    }

    @WebMethod(operationName = "setQuantite")
    public void setQuantite(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) throws ProduitException{
        Long idp = Long.parseLong(id);
        Long pru = Long.parseLong(prixUnitaire);
        ejbRef.setQuantite(idp, pru);
    }

    @WebMethod(operationName = "setPrixUnitaire")
    public void setPrixUnitaire(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) throws ProduitException{
        Long idp = Long.parseLong(id);
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.setPrixUnitaire(idp, prxu);
    }

    @WebMethod(operationName = "supprimerProduit")
    public void supprimerProduit(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        ejbRef.supprimerProduit(idp);
    }

    @WebMethod(operationName = "modifierProduit")
    public void modifierProduit(@WebParam(name = "id") String id, @WebParam(name = "libele") String libele, @WebParam(name = "description") String description) throws ProduitException{
        Long idp = Long.parseLong(id);
        ejbRef.modifierProduit(idp, libele, description);
    }

    @WebMethod(operationName = "isProduitEnStock")
    public boolean isProduitEnStock(@WebParam(name = "id") String id) throws ProduitException{
        Long idp = Long.parseLong(id);
        return ejbRef.isProduitEnStock(idp);
    }
    
    @WebMethod(operationName = "creerUtilisateurCommercial")
    public Utilisateur creerUtilisateurCommercial(@WebParam(name = "id") String id, @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) throws UtilisateurException {
        Long idp = Long.parseLong(id);
        return ejbRef.creerUtilisateurCommercial(idp, nom, prenom);
    } 
    
    @WebMethod(operationName = "creerUtilisateurLivreur")
    public Utilisateur creerUtilisateurLivreur(@WebParam(name = "id") String id, @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) throws UtilisateurException {
        Long idp = Long.parseLong(id);
        return ejbRef.creerUtilisateurLivreur(idp, nom, prenom);
    }
    
    @WebMethod(operationName = "getMiageCompteBancaire")
    public Long getMiageCompteBancaire() throws UtilisateurException {
        return ejbRef.getMiageCompteBancaire();
    }

    @WebMethod(operationName = "setMiageCompteBancaire")
    public void setMiageCompteBancaire(@WebParam(name = "num") String num) throws UtilisateurException {
        Long numC = Long.parseLong(num);
        ejbRef.setMiageCompteBancaire(numC);
    }

    @WebMethod(operationName = "creerUtilisateurAdmin")
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException {
        return ejbRef.creerUtilisateurAdmin();
    }
}
