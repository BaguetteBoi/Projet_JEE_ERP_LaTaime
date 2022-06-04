/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.ws;

import fr.miage.toulouse.m1.JEE.entities.Commande;
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

    @WebMethod(operationName = "getCommandesNnLivres")
    public List<Commande> getCommandesNnLivres(@WebParam(name = "commandes") List<Commande> commandes) {
        return ejbRef.getCommandesNnLivres(commandes);
    }

    @WebMethod(operationName = "getCommandesLivres")
    public List<Commande> getCommandesLivres(@WebParam(name = "commandes") List<Commande> commandes) {
        return ejbRef.getCommandesLivres(commandes);
    }

    @WebMethod(operationName = "getCommandesAnnules")
    public List<Commande> getCommandesAnnules(@WebParam(name = "commandes") List<Commande> commandes) {
        return ejbRef.getCommandesAnnules(commandes);
    }

    @WebMethod(operationName = "setStatusCommande")
    @Oneway
    public void setStatusCommande(@WebParam(name = "idCommande") String idCommande, @WebParam(name = "i") String i) {
        Long idc = Long.parseLong(idCommande);
        Integer ind = Integer.parseInt(i);
        ejbRef.setStatusCommande(idc, ind);
    }
    
}
