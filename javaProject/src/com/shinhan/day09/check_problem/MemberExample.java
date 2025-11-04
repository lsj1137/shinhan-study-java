package com.shinhan.day09.check_problem;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
class Member {
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return id+": "+name;
	}
}

public class MemberExample {
	public static void main(String[] args) {
		Member member = new Member("blue", "임세준");
		System.out.println(member);
	}
}
