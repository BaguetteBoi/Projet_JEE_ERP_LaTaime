/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.metier;

import fr.miage.toulouse.m1.JEE.entities.TypeProduit;
import fr.miage.toulouse.m1.JEE.facades.TypeProduitFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AntoineGougault
 */
@Stateless
public class MetierTypeProduit implements MetierTypeProduitLocal {

    @EJB
    private TypeProduitFacadeLocal typeProduitFacade;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<TypeProduit> getAllTypeProduit() {
        return typeProduitFacade.findAll();
    }

    @Override
    public TypeProduit getTypeProduit(Long id) {
        return typeProduitFacade.find(id);
    }

    @Override
    public void creerTypeProduit(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerTypeProduit(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
