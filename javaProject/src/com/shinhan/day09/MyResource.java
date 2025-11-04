package com.shinhan.day09;

// 자동으로 자원 닫기 테스트
public class MyResource implements AutoCloseable {

	String name;

	public MyResource(String name) {
		super();
		this.name = name;
		System.out.println(name + " 열기(MyResource)");
	}

	public String read1() {
		System.out.println(name + " 읽기1(MyResource)");
		return "100";
	}

	public String read2() {
		System.out.println(10 / 0); // 고의적으로 예외 생성함 하지만 close는 수행됨
		System.out.println(name + " 읽기2(MyResource)");
		return "200";
	}

	@Override
	public void close() throws Exception {
		System.out.println(getClass().getSimpleName() + " 자동 닫힘");
	}

}
