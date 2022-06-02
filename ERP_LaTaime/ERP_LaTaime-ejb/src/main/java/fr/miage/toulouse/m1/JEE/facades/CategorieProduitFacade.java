/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import fr.miage.toulouse.m1.JEE.entities.Produit;
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
    public void creerTypeProduit(String libelle) {
        CategorieProduit typeProduit = new CategorieProduit();
        typeProduit.setLibelle(libelle);
        this.create(typeProduit);
    }

    @Override
    public void supprimerTypeProduit(Long id) {
        CategorieProduit cp = find(id);
        this.remove(cp);
    }
    
    @Override
    public List<CategorieProduit> getAllTypeProduit() {
        List<CategorieProduit> cp = findAll();
        return cp;
    }

    @Override
    public void majTypeProduit(Long id, String libelle) {
        CategorieProduit cp = find(id);
        cp.setLibelle(libelle);
        this.edit(cp);
    }
    
}
