/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exposition;

import fr.miage.toulouse.m1.JEE.entities.Commande;
import fr.miage.toulouse.m1.JEE.entities.Utilisateur;
import fr.miage.toulouse.m1.JEE.metier.MetierCommandeLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierProduitLocal;
import fr.miage.toulouse.m1.JEE.metier.MetierUtilisateurLocal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class ExpoLegClient implements ExpoLegClientLocal {

    @EJB
    private MetierUtilisateurLocal metierUtilisateur;

    @EJB
    private MetierProduitLocal metierProduit;

    @EJB
    private MetierCommandeLocal metierCommande;

    @Override
    public void CreerUtilisateur(String nom, String prenom) {
       this.metierUtilisateur.CreerUtilisateur(nom, prenom);
    }

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) {
      return this.metierUtilisateur.getUtilisateur(idUtilisateur);
        }

    @Override
    public List<Commande> getCommandes(Long id) {
      return this.metierUtilisateur.getCommandes(id);
    }

   public void creerCommande(Utilisateur u, Map d, Date dateCommande){
      this.metierCommande.creerCommande(u, d, dateCommande);
    }
   
   public void annulerCommande (Long id)
   {
       this.metierCommande.annulerCommande(id);
   }
   public void crediterSolde(Long id, Long solde)
   {
       this.metierUtilisateur.crediterSolde(id, solde);
   }
   
    public void debiterSolde(Long id, Long solde){
        this.metierUtilisateur.debiterSolde(id, solde);
    }
}
