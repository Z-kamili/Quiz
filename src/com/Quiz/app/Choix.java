package com.Quiz.app;

public class Choix {
	
	private int num;
	private String Desc;
	public Choix(int num, String desc) {
		super();
		this.num = num;
		Desc = desc;
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
	
	

}
