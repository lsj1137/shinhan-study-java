package com.shinhan.day06.memberManager;

// Service: 비즈니스 로직(업무 로직)
// ~ DAO(Data Access Object): DB에 접근하는 객체
public class MemberService {
	
	String loginId;
	
	boolean login(String id, String password) {
		MemberDAO dao = new MemberDAO();
		if (dao.login(id, password)) {
			loginId = id;
			return true;
		}
		return false;
	}
	
	boolean logout(String id) {
		return loginId.equals(id);
	}
}
