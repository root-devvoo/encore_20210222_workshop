package com.encore.service.test;

import com.encore.service.NoteBook;
import com.encore.service.Programmer;
import com.encore.util.MyDate;

public class ProgrammerTest {

	public static void main(String[] args) {
		//1. Programmer 객체를 생성
		Programmer pro = new Programmer("James", new MyDate(1980, 1, 1), "Java", "Encore"); 
		//2. Programmer가 NoteBook를 가짐
		pro.buyNotebook(new NoteBook(111, "HP", 230));
		//3. 개발자 정보와 노트북 정보를 출력
		NoteBook myNoteBook = pro.getNotebook();
		System.out.println("james가 구매한 노트북의 정보입니다..");
		System.out.println(myNoteBook.getNoteBookInfo());
		
		System.out.println("\nJames의 정보입니다.");
		System.out.println(pro.getProgrammerInfo());
		//4. 더 필요한 기능이 있다면 각자 알아서 추가해서 로직을 작성...
		
	}
}
