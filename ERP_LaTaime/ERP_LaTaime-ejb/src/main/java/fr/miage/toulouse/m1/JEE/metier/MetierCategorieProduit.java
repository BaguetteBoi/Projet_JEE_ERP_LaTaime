/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.exceptions.CategorieProduitException;
import fr.miage.toulouse.m1.JEE.exceptions.ProduitException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.toulouse.m1.JEE.facades.CategorieProduitFacadeLocal;
import fr.miage.toulouse.m1.JEE.facades.ProduitFacadeLocal;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class MetierCategorieProduit implements MetierCategorieProduitLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;

    @EJB
    private CategorieProduitFacadeLocal CategorieProduitFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<CategorieProduit> getAllCategorieProduit() {
        return CategorieProduitFacade.findAll();
    }

    @Override
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException {
        return CategorieProduitFacade.getCategorieProduit(id);
    }

    @Override
    public void creerCategorieProduit(String libelle) {
        CategorieProduitFacade.creerCategorieProduit(libelle);
    }

    @Override
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException {
        CategorieProduitFacade.supprimerCategorieProduit(id);
    }

    @Override
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException {
        CategorieProduitFacade.majCategorieProduit(id, libelle);
    }

    @Override
    public void ajouterProduitACategorieProduit(Long idQ, Long IdP) throws CategorieProduitException, ProduitException {
        CategorieProduitFacade.ajouterProduitACategorieProduit(idQ, produitFacade.getProduit(IdP));
    }
}
