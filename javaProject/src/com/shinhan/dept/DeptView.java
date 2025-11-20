package com.shinhan.dept;

import java.util.List;

public class DeptView {

	public static void menu() {
		System.out.println("====== 작업을 선택하세요 ======");
		System.out.println("1. 모두 조회   2. 부서 번호로 조회   3. 조건 조회\n4. 부서 추가   5. 부서 추가(필수 정보만)\n6. 부서 정보 수정   7. 부서 삭제");
		System.out.print("작업 선택 >> ");
		
	}
	
	public static void print(String message) {
		System.out.println("=== 알림 ===");
		System.out.println(message);
	}
	
	public static void print(DeptDTO emp) {
		System.out.println(emp);
	}
	
	public static void print(List<DeptDTO> empList) {
		System.out.println("=== 여러 건의 정보 ===");
		for (DeptDTO emp:empList) {
			print(emp);
		}
	}

	public static void insertRequest(String reqMessage) {
		System.out.print(reqMessage);
		
	}
}
