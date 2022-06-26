/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import fr.miage.toulouse.m1.JEE.facades.UtilisateurFacadeLocal;
import fr.miage.toulouse.m1.JEE.utility.ClientWebServices;
import fr.miage.toulouse.m1.JEE.utility.ClientWebServices_Service;
import fr.miage.toulouse.m1.JEE.utility.CompteClotureException_Exception;
import fr.miage.toulouse.m1.JEE.utility.CompteInconnuException_Exception;
import fr.miage.toulouse.m1.JEE.utility.MontantInvalidException_Exception;
import fr.miage.toulouse.m1.JEE.utility.SoldeInsufisantException_Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author AdnaneElBeqqali
 */
@Stateless
public class MetierUtilisateur implements MetierUtilisateurLocal {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/ClientWebServices/ClientWebServices.wsdl")
    private ClientWebServices_Service service;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) throws UtilisateurException{
        return this.utilisateurFacade.getUtilisateur(idUtilisateur);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Commande> getCommandes(Long id) throws UtilisateurException{

        return this.utilisateurFacade.getCommandes(id);
    }
    
     @Override
    public void statutsolde(Long id) throws UtilisateurException{
        this.utilisateurFacade.getStatutSoldeCompte(id);
    }
    
    @Override
    public void crediterSolde(Long id, Double solde) throws UtilisateurException{
        
        Utilisateur client = utilisateurFacade.find(id);
        //ClientRest.CallVirementMiageBank(client.getNumCompteBancaire(), utilisateurFacade.getMiageCompteBancaire(), solde);
        
        
        try { // Call Web Service Operation
            ClientWebServices port = service.getClientWebServicesPort();
            // TODO initialize WS operation arguments here
            long idCompteDebiteur = client.getNumCompteBancaire();
            long idCompteCrediteur = utilisateurFacade.getMiageCompteBancaire();
            double montant = solde;
            port.virer(idCompteDebiteur, idCompteCrediteur, montant);
            //Si pas d'exception remonter par la MiageBanque on peut crediter le Solde
            this.utilisateurFacade.crediterSolde(id, solde);
        } catch (Exception ex) {
            Logger.getLogger(MetierUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
     public void debiterSolde(Long id, Double solde) throws UtilisateurException{
         this.utilisateurFacade.debiterSolde(id, solde);
     }
     
     @Override
     public Utilisateur creerUtilisateurClient(String nom, String prenom){
         return this.utilisateurFacade.creerUtilisateurClient(nom, prenom);
     }
     
     @Override
     public Utilisateur creerUtilisateurCommercial(Long id, String nom, String prenom) throws UtilisateurException{
         return this.utilisateurFacade.creerUtilisateurCommercial(id, nom, prenom);
     }
     
     @Override
     public Utilisateur creerUtilisateurLivreur(Long id, String nom, String prenom) throws UtilisateurException{
         return this.utilisateurFacade.creerUtilisateurLivreur(id, nom, prenom);
     }

    @Override
    public Double getStatutSoldeCompte(Long id) throws UtilisateurException {
        return utilisateurFacade.getStatutSoldeCompte(id);
    }

    @Override
    public Long getMiageCompteBancaire() throws UtilisateurException {
        return utilisateurFacade.getMiageCompteBancaire();
    }

    @Override
    public void setMiageCompteBancaire(Long num) throws UtilisateurException {
        utilisateurFacade.setMiageCompteBancaire(num);
    }

    @Override
    public void setUtilisateurCompteBancaire(Long id, Long num) throws UtilisateurException {
        utilisateurFacade.setUtilisateurCompteBancaire(id, num);
    }

    @Override
    public Utilisateur creerUtilisateurAdmin() throws UtilisateurException {
        return utilisateurFacade.creerUtilisateurAdmin();
    }
}
