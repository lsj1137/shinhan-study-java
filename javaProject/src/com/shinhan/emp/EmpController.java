package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpController {
	static EmpService service = new EmpService();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean isStop = false;
		while (!isStop) {
			EmpView.menu();
			int job = Integer.valueOf(sc.nextLine());
			switch (job) {
			case 1 -> f_selectAll();
			case 2 -> f_selectById();
			case 3 -> f_selectByDepId();
			case 4 -> f_selectByCondition();
			default -> isStop = true;
			}
		}
		System.out.println("종료합니다...");
	}

	private static Object f_selectByCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void f_selectByDepId() {
		System.out.print("어떤 부서ID로 조회할까요? ");
		int depId = Integer.parseInt(sc.nextLine());
		EmpView.print(service.selectByDepId(depId));
	}

	private static void f_selectById() {
		System.out.print("어떤 ID를 조회할까요? ");
		int id = Integer.parseInt(sc.nextLine());
		EmpView.print(service.selectById(id));
	}

	private static void f_selectAll() {
		EmpView.print(service.selectAll());
	}
	
	
}
