package com.shinhan.day05;

import java.time.LocalDate;
import java.util.Scanner;

/*
 * 고객관리 (등록, 수정, 모두 조회, 조건 조회)
 * 고객(고객번호, 이름, 전화번호, 생일, 등록일, level(gold, silver, brown))
 */
public class Review {

	static Scanner sc = new Scanner(System.in);
	static CustomerManager cm = new CustomerManager();

	public static void main(String[] args) {
//		f1();
//		f2();
		boolean isContinue = true;
		while (isContinue) {
			menuPrint();
			String jobSelect = sc.nextLine();
			switch (jobSelect) {
			case "insert", "I", "i","ㅑ" -> {
				f_insert();
			}
			case "update", "U", "u","ㅕ" -> {
				f_update();
			}
			case "selectAll", "A", "a","ㅁ" -> {
				cm.selectAll();
			}
			case "condition", "C", "c","ㅊ" -> {
				f_condition();
			}
			case "condition2", "C2", "c2","ㅊ2" -> {
				f_condition2();
			}
			case "delete", "D","d","ㅇ" -> {
				f_delete();
			}
			case "quit", "Q","q","ㅂ" -> {
				isContinue = false;
			}
			default -> {
			}
			}
		}
		System.out.println("--------------END--------------");
	}

	private static void f_condition2() {
		System.out.println("조회할 전화번호> ");
		String phoneNum = sc.nextLine();
		cm.selectCondition2(phoneNum);
		
	}

	private static void f_condition() {
		System.out.println("조회할 level (gold | silver | bronze)> ");
		String level = sc.nextLine();
		cm.selectCondition(level);
	}

	private static void f_delete() {
		System.out.print("삭제할 고객 id> ");
		int selectedId = Integer.parseInt(sc.nextLine());
		cm.delete(selectedId);
	}

	private static void f_update() {
		System.out.print("바꿀 고객 id> ");
		int selectedId = Integer.parseInt(sc.nextLine());
		System.out.print("새 고객 이름> ");
		String newName = sc.nextLine();
		System.out.print("새 고객 전화번호> ");
		String newPhoneNum = sc.nextLine();
		cm.update(selectedId, newName, newPhoneNum);
	}

	private static void f_insert() {
		Customer newCust = null;
		System.out.print("(필수) 고객이름 전화번호> ");
		String newName = sc.next();
		String newPhoneNum = sc.next();
		sc.nextLine();
		System.out.print("(선택) 생일(년-월-일)> ");
		String[] dateInput = sc.nextLine().split("-");
		LocalDate newBirthday = null;
		if (dateInput.length == 3) {
			try {
				int yyyy = Integer.parseInt(dateInput[0]);
				int mm = Integer.parseInt(dateInput[1]);
				int dd = Integer.parseInt(dateInput[2]);
				newBirthday = LocalDate.of(yyyy, mm, dd);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		newCust = new Customer(newName, newPhoneNum, newBirthday);
		cm.insert(newCust);
	}

	private static void menuPrint() {
		System.out.println("------------------------------");
		System.out.println("insert(I) update(U) selectAll(A)");
		System.out.println("condition(C) condition2(C2) delete(D) quit(Q)");
		System.out.println("------------------------------");
		System.out.print("작업선택 > ");
	}

	private static void f2() {
		CustomerManager manager = new CustomerManager();
		Customer c1 = new Customer("임", "010-8773-1137", LocalDate.of(2001, 01, 23));
		Customer c2 = new Customer("김", "010-1425-1249");
		manager.insert(c1);
		manager.insert(c2);
		manager.selectAll();

	}

	private static void f1() {
		Customer.getCustCount();
		Customer c1 = new Customer("임", "010-8773-1137", LocalDate.of(2001, 01, 23));
		Customer c2 = new Customer("김", "010-1425-1249");
		Customer.getCustCount();
		System.out.println(c1);
		System.out.println(c2);
	}

}
