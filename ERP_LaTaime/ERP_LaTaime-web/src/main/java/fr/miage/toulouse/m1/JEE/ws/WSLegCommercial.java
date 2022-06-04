/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
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

    @WebMethod(operationName = "creerTypeProduit")
    @Oneway
    public void creerTypeProduit(@WebParam(name = "libelle") String libelle) {
        ejbRef.creerTypeProduit(libelle);
    }

    @WebMethod(operationName = "supprimerTypeProduit")
    @Oneway
    public void supprimerTypeProduit(@WebParam(name = "id") String id) {
        Long idp = Long.parseLong(id);
        ejbRef.supprimerTypeProduit(idp);
    }

    @WebMethod(operationName = "majTypeProduit")
    @Oneway
    public void majTypeProduit(@WebParam(name = "id") String id, @WebParam(name = "libelle") String libelle) {
        Long idp = Long.parseLong(id);
        ejbRef.majTypeProduit(idp, libelle);
    }

    @WebMethod(operationName = "getAllTypeProduit")
    public List<CategorieProduit> getAllTypeProduit() {
        return ejbRef.getAllTypeProduit();
    }

    @WebMethod(operationName = "creerProduit")
    @Oneway
    public void creerProduit(@WebParam(name = "libele") String libele, @WebParam(name = "prixUnitaire") String prixUnitaire, @WebParam(name = "description") String description) {
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.creerProduit(libele, prxu, description);
    }

    @WebMethod(operationName = "getProduit")
    public Produit getProduit(@WebParam(name = "id") String id) {
        Long idp = Long.parseLong(id);
        return ejbRef.getProduit(idp);
    }

    @WebMethod(operationName = "getAllProduits")
    public List<Produit> getAllProduits() {
        return ejbRef.getAllProduits();
    }

    @WebMethod(operationName = "setQuantite")
    @Oneway
    public void setQuantite(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) {
        Long idp = Long.parseLong(id);
        Long pru = Long.parseLong(prixUnitaire);
        ejbRef.setQuantite(idp, pru);
    }

    @WebMethod(operationName = "setPrixUnitaire")
    @Oneway
    public void setPrixUnitaire(@WebParam(name = "id") String id, @WebParam(name = "prixUnitaire") String prixUnitaire) {
        Long idp = Long.parseLong(id);
        Double prxu = Double.parseDouble(prixUnitaire);
        ejbRef.setPrixUnitaire(idp, prxu);
    }

    @WebMethod(operationName = "supprimerProduit")
    @Oneway
    public void supprimerProduit(@WebParam(name = "id") String id) {
        Long idp = Long.parseLong(id);
        ejbRef.supprimerProduit(idp);
    }

    @WebMethod(operationName = "modifierProduit")
    @Oneway
    public void modifierProduit(@WebParam(name = "id") String id, @WebParam(name = "libele") String libele, @WebParam(name = "description") String description) {
        Long idp = Long.parseLong(id);
        ejbRef.modifierProduit(idp, libele, description);
    }

    @WebMethod(operationName = "isProduitEnStock")
    public boolean isProduitEnStock(@WebParam(name = "id") String id) {
        Long idp = Long.parseLong(id);
        return ejbRef.isProduitEnStock(idp);
    }
    
}
