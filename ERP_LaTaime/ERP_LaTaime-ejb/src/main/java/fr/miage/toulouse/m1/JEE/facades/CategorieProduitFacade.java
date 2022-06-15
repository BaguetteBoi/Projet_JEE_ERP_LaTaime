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

    @Override
    public void creerCategorieProduit(String libelle) {
        CategorieProduit typeProduit = new CategorieProduit();
        typeProduit.setLibelle(libelle);
        typeProduit.setProduits(new ArrayList<Produit>());
        this.create(typeProduit);
    }
    
    @Override
    public CategorieProduit getCategorieProduit(Long id) throws CategorieProduitException{
        CategorieProduit cp = find(id);
        if(cp != null){
            return cp;
        }else{
            throw new CategorieProduitException("Id CategorieProduit "+ id+ "inconnue");
        }
    }

    @Override
    public void supprimerCategorieProduit(Long id) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        this.remove(cp);
    }
    
    @Override
    public List<CategorieProduit> getAllCategorieProduit() {
        List<CategorieProduit> cp = findAll();
        return cp;
    }

    @Override
    public void majCategorieProduit(Long id, String libelle) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        cp.setLibelle(libelle);
        this.edit(cp);
    }

    @Override
    public void ajouterProduitACategorieProduit(Long id, Produit p) throws CategorieProduitException{
        CategorieProduit cp = getCategorieProduit(id);
        cp.addProduit(p);
        this.edit(cp);
    }
}
