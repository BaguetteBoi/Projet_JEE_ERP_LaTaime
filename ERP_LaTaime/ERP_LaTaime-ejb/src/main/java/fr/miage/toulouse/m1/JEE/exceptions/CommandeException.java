/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.exceptions;

/**
 *
 * @author AntoineGougault
 */
public class CommandeException extends Exception{
    
    /**
     *
     * @param message
     */
    public CommandeException(String message) {
        super(message);
    }
}
