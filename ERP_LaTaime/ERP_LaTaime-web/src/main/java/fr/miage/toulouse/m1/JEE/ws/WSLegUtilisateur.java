/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import fr.miage.toulouse.m1.JEE.exposition.ExpoLegClientLocal;

/**
 *
 * @author AntoineGougault
 */
@WebService(serviceName = "WSLegUtilisateur")
public class WSLegUtilisateur {

    @EJB
    private ExpoLegClientLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "CreerUtilisateur")
    @Oneway
    public void CreerUtilisateur(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) {
        ejbRef.CreerUtilisateur(nom, prenom);
    }

    @WebMethod(operationName = "getUtilisateur")
    public Utilisateur getUtilisateur(@WebParam(name = "idUtilisateur") Long idUtilisateur) {
        return ejbRef.getUtilisateur(idUtilisateur);
    }

    @WebMethod(operationName = "getCommandes")
    public List<Commande> getCommandes(@WebParam(name = "id") Long id) {
        return ejbRef.getCommandes(id);
    }
    
}
