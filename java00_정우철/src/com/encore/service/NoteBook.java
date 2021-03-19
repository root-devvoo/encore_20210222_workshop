package com.encore.service;

public class NoteBook {
	//필드 선언
	public int serialNum;
	public String brand;
	public int price;
	
	//주입
	public NoteBook(int serialNum, String brand, int price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.price = price;
	}
	
	//노트북 정보
	public String getNoteBookInfo() {
		return serialNum+", " + brand +", " + price; 
	}
}
