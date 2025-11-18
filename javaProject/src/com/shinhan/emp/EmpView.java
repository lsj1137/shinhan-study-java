package com.shinhan.emp;

import java.util.List;

// 사용자에게 결과를 출력할 목적
// JSP -> HTML 로 대체할 예정
public class EmpView {
	public static void menu() {
		System.out.println("====== 작업을 선택하세요 ======");
		System.out.println("1. 모두 조회   2. 직원번호로 조회   3. 부서로 조회   4. 조건 조회");
		System.out.print("작업 선택 >> ");
		
	}
	
	public static void print(String message) {
		System.out.println("=== 알림 ===");
		System.out.println(message);
	}
	
	public static void print(EmpDTO emp) {
		System.out.println(emp);
	}
	
	public static void print(List<EmpDTO> empList) {
		System.out.println("=== 여러 건의 정보 ===");
		for (EmpDTO emp:empList) {
			print(emp);
		}
	}
	
}
