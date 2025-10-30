package com.shinhan.day06.memberManager;

/*
 * [MVC 모델]
 * Model: Serivce+DAO 처리 담당
 * View: 출력 담당
 * Controller: 요청, 응답 담당
 * 
 * 1. 사용자가 Controller에게 요청을 보냄
 * 2. Controller가 Service 호출
 * 3. Service는 업무 로직을 수행. DB가 필요하면 DAO 호출.
 * 4. Service가 결과를 Controller에게 전달.
 * 5. View에게 결과를 보내서 출력함.
 */
public class MemberController {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		if (result) {
			MemberView.print("로그인 되었습니다.");
			boolean result2 = memberService.logout("hong");
			if (result2) {
				MemberView.print("hong님이 로그아웃 되었습니다");
			}
		} else {
			MemberView.print("id 또는 password가 올바르지 않습니다.");
		}
	}
}
