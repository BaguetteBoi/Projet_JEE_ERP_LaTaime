/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exposition.ExpoLegClientLocal;
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
@WebService(serviceName = "wsTest")
public class wsTest {

    @EJB
    private ExpoLegClientLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getUtilisateur")
    public Utilisateur getUtilisateur(@WebParam(name = "idUtilisateur") Long idUtilisateur) {
        return ejbRef.getUtilisateur(idUtilisateur);
    }

    @WebMethod(operationName = "getCommandes")
    public List<Commande> getCommandes(@WebParam(name = "id") Long id) {
        return ejbRef.getCommandes(id);
    }

    @WebMethod(operationName = "crediterSolde")
    @Oneway
    public void crediterSolde(@WebParam(name = "id") Long id, @WebParam(name = "solde") Long solde) {
        ejbRef.crediterSolde(id, solde);
    }

    @WebMethod(operationName = "debiterSolde")
    @Oneway
    public void debiterSolde(@WebParam(name = "id") Long id, @WebParam(name = "solde") Long solde) {
        ejbRef.debiterSolde(id, solde);
    }

    @WebMethod(operationName = "creerUtilisateurClient")
    @Oneway
    public void creerUtilisateurClient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) {
        ejbRef.creerUtilisateurClient(nom, prenom);
    }

    @WebMethod(operationName = "statutsoldeCompte")
    @Oneway
    public void statutsoldeCompte(@WebParam(name = "id") Long id) {
        ejbRef.statutsoldeCompte(id);
    }
    
}
