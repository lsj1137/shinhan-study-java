package com.shinhan.common;

import java.util.Scanner;

import com.shinhan.dept.DeptController;
import com.shinhan.emp.EmpController;

public class FrontController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		ControllerInterface controller = null;
		while (isRunning) {
			System.out.println("============= HR =============");
			System.out.println("1. EMPLOYEES  2. DEPARTMENTS  99. 종료");
			System.out.print("작업 선택>> ");
			int job = sc.nextInt();
			sc.nextLine();
			switch (job) {
			case 1 -> {
				controller = new EmpController();
			}
			case 2 -> {
				controller = new DeptController();
			}
			case 99 -> {
				isRunning = false;
			}
			default -> System.out.println("잘못된 입력입니다. 다시 선택하세요.");
			}
			if (controller!=null) {
				controller.execute(sc);
			}
			controller = null;
		}
		System.out.println("프로그램을 종료합니다...");
	}
}
