/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import fr.miage.toulouse.m1.JEE.exposition.ExpoLegClientLocal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author AdnaneElBeqqali
 */
@WebService(serviceName = "WSLegClient")
public class WSLegClient {

    @EJB
    private ExpoLegClientLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getUtilisateur")
    public Utilisateur getUtilisateur(@WebParam(name = "idUtilisateur") String idUtilisateur) throws UtilisateurException {
        Long idu = Long.parseLong(idUtilisateur);
        return ejbRef.getUtilisateur(idu);
    }

    @WebMethod(operationName = "getCommandes")
    public List<Commande> getCommandes(@WebParam(name = "id") String id) throws UtilisateurException {
        Long idc = Long.parseLong(id);
        return ejbRef.getCommandes(idc);
    }

    @WebMethod(operationName = "creerCommande")
    public void creerCommande(@WebParam(name = "idU") String id, @WebParam(name = "commande") String commande) throws ProduitException{

        
        /*Sérialisation du string commande en Map<Integer, Integer> -> (idProduit, Qte) 
        ex : "{1=3,65=2,5=1}" */
        commande = commande.substring(1, commande.length() - 1);
        String[] keyValuePairs = commande.split(",");
        Map<Integer, Integer> map = new HashMap<>();

        for (String pair : keyValuePairs)
        {
            String[] entry = pair.split("=");
            map.put(Integer.parseInt(entry[0].trim()), Integer.parseInt(entry[1].trim()));
        }

        Long idu = Long.parseLong(id);
        
        ejbRef.creerCommande(idu, map, new Date());
    }

    @WebMethod(operationName = "annulerCommande")
    public void annulerCommande(@WebParam(name = "id") String id) throws ProduitException{
        Long idu = Long.parseLong(id);
        ejbRef.annulerCommande(idu);
    }

    @WebMethod(operationName = "crediterSolde")
    public void crediterSolde(@WebParam(name = "id") String id, @WebParam(name = "solde") String solde) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Long sld = Long.parseLong(solde);
        ejbRef.crediterSolde(idu, sld);
    }

    @WebMethod(operationName = "debiterSolde")
    public void debiterSolde(@WebParam(name = "id") String id, @WebParam(name = "solde") String solde) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Long sld = Long.parseLong(solde);
        ejbRef.debiterSolde(idu, sld);
    }

    @WebMethod(operationName = "creerUtilisateurClient")
    public void creerUtilisateurClient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) {
        ejbRef.creerUtilisateurClient(nom, prenom);
    }

    @WebMethod(operationName = "demanderfacture")
    public void demanderfacture(@WebParam(name = "id") String id) {
        Long idu = Long.parseLong(id);
        ejbRef.demanderfacture(idu);
    }

    @WebMethod(operationName = "statutsoldeCompte")
    public void statutsoldeCompte(@WebParam(name = "id") String id) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        ejbRef.statutsoldeCompte(idu);
    }
    
    @WebMethod(operationName = "setUtilisateurCompteBancaire")
    public void setUtilisateurCompteBancaire(@WebParam(name = "id") String id, @WebParam(name = "num") String num) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Long numS = Long.parseLong(num);
        ejbRef.setUtilisateurCompteBancaire(idu, numS);
    }
}
