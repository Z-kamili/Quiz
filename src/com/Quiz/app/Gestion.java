package com.Quiz.app;

import java.util.HashMap;
import java.util.Map;

public class Gestion {
	
	private Map<Réponse, Integer> reponse;

	public Gestion(Map<Réponse, Integer> reponse) {
		this.reponse = reponse;
	}

	public Map<Réponse, Integer> getReponse() {
		return reponse;
	}

	public void setReponse(Map<Réponse, Integer> reponse) {
		this.reponse = reponse;
	}
	
	
public void afficher() {
		
		System.out.println("-------Nom du reponse---------||------Question-----------");
		for (Map.Entry<Réponse, Integer> entry : reponse.entrySet()) {
	        System.out.println("-------" + entry.getKey().getDesc()  + "-------------------------" +  entry.getValue() + "---------");
	    }
	}
	
	
	
	
	

}
