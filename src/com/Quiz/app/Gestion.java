package com.Quiz.app;

import java.util.HashMap;
import java.util.Map;

public class Gestion {
	
	private Map<R�ponse, Integer> reponse;

	public Gestion(Map<R�ponse, Integer> reponse) {
		this.reponse = reponse;
	}

	public Map<R�ponse, Integer> getReponse() {
		return reponse;
	}

	public void setReponse(Map<R�ponse, Integer> reponse) {
		this.reponse = reponse;
	}
	
	
public void afficher() {
		
		System.out.println("-------Nom du reponse---------||------Question-----------");
		for (Map.Entry<R�ponse, Integer> entry : reponse.entrySet()) {
	        System.out.println("-------" + entry.getKey().getDesc()  + "-------------------------" +  entry.getValue() + "---------");
	    }
	}
	
	
	
	
	

}
