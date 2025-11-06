package com.shinhan.day11.check_problem;

public class Container <T>{
	T content;
	
	void set(T t) {
		content = t;
	}
	
	T get() {
		return content;
	}
}
