/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.CommandeException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.UtilisateurException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface ExpoLegClientLocal {

    public Utilisateur getUtilisateur(Long idUtilisateur) throws UtilisateurException;

    public void creerCommande(Long idU, Map<Integer, Integer> d, Date dateCommande) throws ProduitException, UtilisateurException;

    public void annulerCommande(Long id) throws ProduitException, CommandeException;

    public List<Commande> getCommandes(Long id) throws UtilisateurException;

    public void crediterSolde(Long id, Double solde) throws UtilisateurException;

    public void debiterSolde(Long id, Double solde) throws UtilisateurException;

    public Utilisateur creerUtilisateurClient(String nom, String prenom);

    public String demanderfacture(Long id) throws CommandeException;

    public Double getStatutSoldeCompte(Long id) throws UtilisateurException;

    public void setUtilisateurCompteBancaire(Long id, Long num) throws UtilisateurException;
}
