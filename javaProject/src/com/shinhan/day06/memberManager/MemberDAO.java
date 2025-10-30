package com.shinhan.day06.memberManager;

public class MemberDAO {
	String db_id = "hong";
	String db_pw = "12345";
	
	boolean login(String id, String password) {
		return id.equals(db_id) && password.equals(db_pw);
	}
	
	boolean logout(String id) {
		return id.equals(db_id);
	}
	
}
