/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
import fr.miage.toulouse.m1.JEE.exceptions.CategorieProduitException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class CategorieProduitFacade extends AbstractFacade<CategorieProduit> implements CategorieProduitFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.toulouse.m1.JEE_ERP_LaTaime-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieProduitFacade() {
        super(CategorieProduit.class);
    }

    /**
     * Méthode permettant de créer une Catégorie de produit
     * @param libelle
     */
    @Override
    public void creerCategorieProduit(String libelle) {
        CategorieProduit typeProduit = new CategorieProduit();
        typeProduit.setLibelle(libelle);
        typeProduit.setProduits(new ArrayList<Produit>());
        this.create(typeProduit);
    }
    
    /**
     * Méthode permettant de récupérer une catégorie de produit
     * @param id
     * @return
     * @throws CategorieProduitException
     */
    @Override
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException{
        CategorieProduit cp = find(id);
        if(cp != null){
            return cp;
        }else{
            throw new CategorieProduitException("Id CategorieProduit "+ id+ "inconnue");
        }
    }

    /**
     * Méthode permettant de supprimer une catégorie de produit
     * @param id
     * @throws CategorieProduitException
     */
    @Override
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        this.remove(cp);
    }
    
    /**
     * Méthode permettant de renvoie toutes les catégorie de produit
     * @return
     */
    @Override
    public List<CategorieProduit> getAllCategorieProduit() {
        List<CategorieProduit> cp = findAll();
        return cp;
    }

    /**
     * Méthode permettant de modifié le libelle d'une catégorie de produit
     * @param id
     * @param libelle
     * @throws CategorieProduitException
     */
    @Override
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        cp.setLibelle(libelle);
        this.edit(cp);
    }

    /**
     * Méthode permettant d'ajouter un produit à une catégorie de produit
     * @param id
     * @param p
     * @throws CategorieProduitException
     */
    @Override
    public void ajouterProduitACategorieProduit(Long id, Produit p) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        cp.addProduit(p);
        this.edit(cp);
    }
}
