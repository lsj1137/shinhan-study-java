package com.shinhan.day11.check_problem;

public class Container2 <T1, T2>{
	T1 key;
	T2 value;
	
	void set(T1 t1, T2 t2) {
		key = t1;
		value = t2;
	}
	
	T1 getKey() {
		return key;
	}
	
	T2 getValue() {
		return value;
	}
}
