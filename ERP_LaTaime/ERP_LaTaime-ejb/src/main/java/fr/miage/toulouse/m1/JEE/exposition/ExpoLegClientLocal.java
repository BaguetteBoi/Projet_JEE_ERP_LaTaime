/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
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
  public Utilisateur getUtilisateur(Long idUtilisateur);
  public void creerCommande(Long idU, Map<Integer, Integer> d, Date dateCommande) throws ProduitException;
  public void annulerCommande (Long id) throws ProduitException;
  public List<Commande> getCommandes(Long id);
  public void crediterSolde(Long id, Long solde);
  public void debiterSolde(Long id, Long solde);
  public void creerUtilisateurClient(String nom, String prenom);
  public void demanderfacture(Long id);
  public void statutsoldeCompte(Long id);
}
