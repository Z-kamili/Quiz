package com.Quiz.app;

import java.util.ArrayList;
import java.util.List;

public class Niveau {
	
	private int num;
	private List<Question> question;
	private static int pts;
	
	public Niveau(int num){
		// TODO Auto-generated constructor stub
		question = new ArrayList<Question>(5);
		this.num = num;
		Niveau.pts = 0;
	}

	
	
	public int getPts() {
		return pts;
	}



	public void setPts(int pts) {
		Niveau.pts = pts;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	public void AddQuestion(Question e) {
		// TODO Auto-generated method stub
		question.add(e);
	}
	
	

}
