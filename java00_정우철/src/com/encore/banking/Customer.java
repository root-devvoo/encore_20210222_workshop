package com.encore.banking;

//고객에 관한 정보를 가지고 있는 클래스
//은행업무를 보는 고객... Account를 Hasing해야한다.
public class Customer {
	//필드선언
	public String name;
	public int ssn;
	
	//1.
	public Account account;

	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	//2.
	public void setAccount(Account account) {
		this.account = account;
	}
	
	//3. 고객이 개설한 통장을 받아서 사용하는 기능..
	public Account getAccount() {
		return account;
	}

	
	//고객정보출력
	public String getCustInfo() {
		return "이름: " + name + ", 주민등록번호: " + ssn;
	}
}
