/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.TypeProduit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class TypeProduitFacade extends AbstractFacade<TypeProduit> implements TypeProduitFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.toulouse.m1.JEE_ERP_LaTaime-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeProduitFacade() {
        super(TypeProduit.class);
    }

    @Override
    public void creerTypeProduit(String libelle) {
        TypeProduit typeProduit = new TypeProduit();
        typeProduit.setLibelle(libelle);
        this.create(typeProduit);
    }
    
}
