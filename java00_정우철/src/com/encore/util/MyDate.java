package com.encore.util;

public class MyDate {
	//필드 선언
	public int year;
	public int month;
	public int day;
	
	//주입
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//필드값 받아오기
	public String getDate() {
		return year+"-"+month+"-"+day;
	}
}
