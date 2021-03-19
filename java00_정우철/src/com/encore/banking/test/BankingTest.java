package com.encore.banking.test;

import java.util.Scanner;

import com.encore.banking.Account;
import com.encore.banking.Customer;

public class BankingTest {
	public static void main(String[] args) {
		//1. Customer 객체를 생성..이때 고객 정보는 Scanner객체를 통해서 입력...이름, ssn(주민번호)만
		Scanner sc = new Scanner(System.in); //스캐너 호출
		System.out.println("고객의 이름과 주민번호를 입력하세요>>>");
		
		String name = sc.nextLine();
		int ssn = sc.nextInt();
		
		Customer custom = new Customer(name, ssn);
		
		//2. 고객이 통장을 개설한다.... 이때 Has a Relation이 연결된다.
		custom.setAccount(new Account(10000.0)); //1만원
		
		//3. 고객이 개설한 통장을 반환...
		Account myAccount = custom.getAccount();
		
		//4. 통장을 사용...1만원 입금, 5천원 입금, 2천원 입금, 7천원 출금
		myAccount.deposit(10000.0); //2만원
		myAccount.deposit(300); //2만원
		myAccount.withdraw(10000); //1만원
		myAccount.withdraw(20000); //1만원
		
		//5. 최종적인 잔액을 콘솔로 출력해본다...1만원 + balance
		System.out.println("잔액은 "+myAccount.getBalance()+" 원입니다.!!");
	}
}
