/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
import fr.miage.toulouse.m1.JEE.exposition.ExpoLegLivreurLocal;
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
@WebService(serviceName = "WSLegLivreur")
public class WSLegLivreur {

    @EJB
    private ExpoLegLivreurLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    /**
     * Methode webservice permettant de récupérer toutes les commande dont le status est égale à 'non livrés'
     * @return
     */
    @WebMethod(operationName = "getCommandesNnLivres")
    public List<Commande> getCommandesNnLivres() {
        return ejbRef.getCommandesNnLivres();
    }

    /**
     * Methode webservice permettant de récupérer toutes les commande dont le status est égale à 'livrés'
     * @return
     */
    @WebMethod(operationName = "getCommandesLivres")
    public List<Commande> getCommandesLivres() {
        return ejbRef.getCommandesLivres();
    }

    /**
     * Methode webservice permettant de récupérer toutes les commande dont le status est égale à 'annulé'
     * @return
     */
    @WebMethod(operationName = "getCommandesAnnules")
    public List<Commande> getCommandesAnnules() {
        return ejbRef.getCommandesAnnules();
    }

    /**
     * Methode webservice permettant changer le status d'une commande
     * @param idCommande
     * @param status
     * @throws CommandeException
     */
    @WebMethod(operationName = "setStatusCommande")
    @Oneway
    public void setStatusCommande(@WebParam(name = "idCommande") String idCommande, @WebParam(name = "status") String status) throws CommandeException{
        Long idc = Long.parseLong(idCommande);
        Integer ind = Integer.parseInt(status);
        ejbRef.setStatusCommande(idc, ind);
    }
    
}
