package com.Quiz.app;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class quiz {
	
	private String name;
	private DateTimeFormatter t;
	private List<Niveau> N;
	private static int cpt;
	
	public quiz(String name, DateTimeFormatter t) {
		super();
		this.name = name;
		this.t = t;
		this.N = new ArrayList<Niveau>(3);
		quiz.cpt = 0;
	}
	
	public static int getQ() {
		return quiz.cpt;
	}

	public static void setQ(int q) {
		quiz.cpt = q;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DateTimeFormatter getT() {
		return t;
	}
	public void setT(DateTimeFormatter t) {
		this.t = t;
	}
	
	public void AddNiveau(Niveau e){
		// TODO Auto-generated method stub
		N.add(e);
	}
	

	
	
	
	
	
	

}
