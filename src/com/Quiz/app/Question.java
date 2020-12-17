package com.Quiz.app;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	private int num;
	private String Desc;
	private List<Choix> choix;
	public Question(int num,String Desc){
		// TODO Auto-generated constructor stub
		this.num = num;
		this.Desc = Desc;
		this.choix = new ArrayList<Choix>();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		this.Desc = desc;
	}
	public List<Choix> getChoix() {
		return choix;
	}
	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}
	
	//ADD choix 
	
	public void AddChoix(Choix e) {
		// TODO Auto-generated method stub
		choix.add(e);
	}
	
public void AfficherChoix(){
		
		int i = 0;
		for(i = 0;i<choix.size();i++) {	
			System.out.println("Desc : " + choix.get(i).getDesc());
		}
	
	
	

}
}
