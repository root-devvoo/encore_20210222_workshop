package com.encore.workshop.test;

import java.util.Scanner;

public class WorkshopTest2 {
	// #################################  메소드 구현  ########################################
		public static int game() {
			Scanner sc = new Scanner(System.in);
			int user = sc.nextInt();
			int com = 0;
				if (user == 1) { System.out.println("가위");
				}else if (user == 2) { System.out.println("주먹");
				}else if (user == 3) { System.out.println("보"); 
				}else {
					System.out.println("입력 오류!!! 다시 시작하세요!");
			}
			// 컴퓨터의 1 ~ 3	사이의 임의 값 입력
			com = (int)(Math.random() * 3) +1;
			// 가위바위보 승부 rule
			if((user == 2 && com == 1 ) || (user == 3 && com == 2) || (user == 1 && com == 3)) { 
				System.out.println("이겼습니다!!!");
				return 1;
			}if((user == 1 && com == 2) || (user == 2 && com == 3) || (user == 3 && com == 1)) {
				System.out.println("졌습니다!!!");
				return -1;	
		    }else {
			System.out.println("비겼습니다!!!");
			return 0; // return이 없으면 실행이 안되므로...	
		    }
		}
		
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("===========================================================");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요. ");
		//보기 선택
		int select = sc.nextInt();
			if (select >= 4) {
				System.out.println("입력 오류!!! 다시 시작하세요!");
				return;
			}
		System.out.println("===========================================================");
		System.out.print("가위바위보 중 하나 입력: ");
		
		// 승수 입력을 위한 초기화 작업
		int userScore;  
		
		int comScore;
		
		userScore = 0;
		comScore = 0;
		
		switch(select) {
		//5판 3승	
		case 1:
			while (userScore < 3 && comScore < 3) { // 3승하면 게임이 끝날 수 있게...
				int game = game();
				if (game == 1) { // 이겼을 경우 메소드로부터 1을 리턴 받고, 유저 승수 + 1
					userScore++;
				}else if (game == -1) { // 졌을 경우 메소드로부터 -1을 리턴 받고, 컴퓨터 승수 + 1
					comScore++;
				}
			}
			if (userScore == 3) { // 유저 3승 일때 도전자 승리 출력
				System.out.println("### 도전자 승!!!");
			}else { // 컴퓨터 3승 일때 컴퓨터 승리 출력
				System.out.println("### 컴퓨터 승!!!");
			}	
		    break;
		//3판 2승    
		case 2:
			while (userScore < 2 && comScore < 2) { // 2승하면 게임 끝날 수 있게...
				int game = game();
				if (game == 1) {
					userScore++;
				}else if (game == -1) {
					comScore++;
				}
			}
			if (userScore == 2) {
				System.out.println("### 도전자 승!!!");
			}else {
				System.out.println("### 컴퓨터 승!!!");
			}
			break;
		//1판 1승	
		case 3:
			while (userScore < 1 && comScore < 1) {
				int game = game();
				if (game == 1) {
					userScore++;
				}else if (game == -1) {
					comScore++;
				}
			}
			if (userScore == 1) {
				System.out.println("### 도전자 승!!!");
			}else {
				System.out.println("### 컴퓨터 승!!!");
			}
			break;
		}		        	
	}

}
