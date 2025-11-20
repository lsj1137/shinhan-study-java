package com.shinhan.emp;

import java.util.List;
import java.util.Map;

// 사용자에게 결과를 출력할 목적
// JSP -> HTML 로 대체할 예정
public class EmpView {
	public static void menu() {
		System.out.println("====== 작업을 선택하세요 ======");
		System.out.println("1. 모두 조회   2. 직원번호로 조회   3. 부서로 조회\n4. 조건 조회   5. 직원 추가   6. 직원 추가(필수 정보만)\n7. 직원 정보 수정   8. 직원 삭제   9. 프로시저");
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

	public static void insertRequest(String reqMessage) {
		System.out.print(reqMessage);
		
	}

	public static void print(Map<String, Object> map) {
		for (String key: map.keySet()) {
			System.out.println(key+": "+map.get(key));
		}
	}
	
}
