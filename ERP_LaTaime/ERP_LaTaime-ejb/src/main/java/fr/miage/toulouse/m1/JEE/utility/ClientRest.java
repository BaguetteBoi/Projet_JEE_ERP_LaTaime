/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m1.JEE.utility;

/**
 *
 * @author AntoineGougault
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class ClientRest {
	
	public static void CallVirementMiageBank(Long CompteClient, Long CompteLaTaime, Long montant){
		Client client = ClientBuilder.newBuilder().newClient();
		WebTarget target = client.target("http://localhost:8080/ClientWebServices/ClientWebServices");
		target = target.path("virer/idCompteDebiteur="+CompteClient+"?CompteClient="+CompteLaTaime+"montant="+montant);
		 
		Invocation.Builder builder = target.request();
		Response response = builder.get();
		//MaRessource maRessource = builder.get(MaRessource.class);
		
	}
}
