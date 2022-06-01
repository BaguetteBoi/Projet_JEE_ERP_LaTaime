/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.facades;

import fr.miage.toulouse.m1.JEE.entities.CategorieProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AntoineGougault
 */
@Local
public interface CategorieProduitFacadeLocal {

    void create(CategorieProduit typeProduit);

    void edit(CategorieProduit typeProduit);

    void remove(CategorieProduit typeProduit);

    CategorieProduit find(Object id);

    List<CategorieProduit> findAll();

    List<CategorieProduit> findRange(int[] range);

    int count();
    
    public void creerTypeProduit(String libelle);
    
}
