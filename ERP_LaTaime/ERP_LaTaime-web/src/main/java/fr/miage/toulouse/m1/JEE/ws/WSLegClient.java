
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
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

    /**
     * Methode webservice permettant de récupérer un utilisateur
     * @param idUtilisateur
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "getUtilisateur")
    public Utilisateur getUtilisateur(@WebParam(name = "idUtilisateur") String idUtilisateur) throws UtilisateurException {
        Long idu = Long.parseLong(idUtilisateur);
        return ejbRef.getUtilisateur(idu);
    }

    /**
     * Methode webservice permettant de récupérer toutes les commandes passé par un utilisateur
     * @param id
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "getCommandes")
    public List<Commande> getCommandes(@WebParam(name = "id") String id) throws UtilisateurException {
        Long idc = Long.parseLong(id);
        return ejbRef.getCommandes(idc);
    }

    /**
     * Methode webservice permettant de créer une commande est de la lier à un utilisateur
     * @param id
     * @param commande
     * @throws ProduitException
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "creerCommande")
    public void creerCommande(@WebParam(name = "idU") String id, @WebParam(name = "commande") String commande) throws ProduitException, UtilisateurException{

        
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

    /**
     * Methode webservice permettant de changer le status d'une commande à "annuler"
     * @param id
     * @throws ProduitException
     * @throws CommandeException
     */
    @WebMethod(operationName = "annulerCommande")
    public void annulerCommande(@WebParam(name = "id") String id) throws ProduitException, CommandeException{
        Long idu = Long.parseLong(id);
        ejbRef.annulerCommande(idu);
    }

    /**
     * Methode webservice permettant de créditer le solde d'un utilisateur en crédit "MIAGE" (un appler en webservice sera fait à la MIAGEBank)
     * @param id
     * @param solde
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "crediterSolde")
    public void crediterSolde(@WebParam(name = "id") String id, @WebParam(name = "solde") String solde) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Double sld = Double.parseDouble(solde);
        ejbRef.crediterSolde(idu, sld);
    }

    /**
     * Methode webservice permettant de débiter le solde d'un utilisateur en crédit "MIAGE"
     * @param id
     * @param solde
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "debiterSolde")
    public void debiterSolde(@WebParam(name = "id") String id, @WebParam(name = "solde") String solde) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Double sld = Double.parseDouble(solde);
        ejbRef.debiterSolde(idu, sld);
    }

    /**
     * Methode webservice permettant de créer un Utilisateur de type "Client"
     * @param nom
     * @param prenom
     * @return
     */
    @WebMethod(operationName = "creerUtilisateurClient")
    public Utilisateur creerUtilisateurClient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) {
        return ejbRef.creerUtilisateurClient(nom, prenom);
    }

    /**
     * Methode webservice permettant de demander une facture pour une commande donné
     * @param id
     * @return
     * @throws CommandeException
     */
    @WebMethod(operationName = "demanderfacture")
    public String demanderfacture(@WebParam(name = "id") String id) throws CommandeException{
        Long idu = Long.parseLong(id);
        return ejbRef.demanderfacture(idu);
    }

    /**
     * Methode webservice permettant de voir le solde de crédit "MIAGE" d'un utilisateur 
     * @param id 
     * @return
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "getStatutSoldeCompte")
    public Double statutsoldeCompte(@WebParam(name = "id") String id) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        return ejbRef.getStatutSoldeCompte(idu);
    }
    
    /**
     * Methode webservice permettant de configurer le numéro de compte bancaire d'un utilisateur
     * @param id
     * @param num
     * @throws UtilisateurException
     */
    @WebMethod(operationName = "setUtilisateurCompteBancaire")
    public void setUtilisateurCompteBancaire(@WebParam(name = "id") String id, @WebParam(name = "num") String num) throws UtilisateurException {
        Long idu = Long.parseLong(id);
        Long numS = Long.parseLong(num);
        ejbRef.setUtilisateurCompteBancaire(idu, numS);
    }
}
