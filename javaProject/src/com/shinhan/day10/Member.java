package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data //default 생성자, getter, setter, toString, equals
@AllArgsConstructor
//@NoArgsConstructor // final 있다면 불가능
@RequiredArgsConstructor
public class Member {
	final String id; // 생성시 초기화 필수
	@NonNull String name; // null 불가
	int age;
}
