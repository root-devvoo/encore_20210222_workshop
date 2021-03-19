package com.encore.service;

import com.encore.util.MyDate;

public class Programmer {
	//필드 선언
	public String name;
	public MyDate birthDate;
	public String company;
	public String tech;
	//hasing
	public NoteBook notebook;
	
	
	public Programmer(String name, MyDate birthDate, String tech, String company) {
		this.name = name;
		this.birthDate = birthDate;
		this.tech = tech;
		this.company = company;
	}
	
	public void buyNotebook(NoteBook notebook) {
		this.notebook = notebook;
	}
	
	public NoteBook getNotebook() {
		return notebook;
	}
	
	public String getProgrammerInfo() {
		return name+", " + birthDate.getDate() +", " + company +", " + tech;
	}
}
