package com.shinhan.day05;

public class Computer {
	// 1. 인스턴스 변수
	/* [Modifier] 변수타입 변수이름
	 * Modifier 접근권한 : public > protected > 생략 > private(정보 은닉, class내에서만 접근 가능)
	 * public: 모든 패키지에서 접근 가능
	 * protected: 같은 패키지에서 접근 가능, 다른 패키지에서 상속 받으면 가능
	 * default: 같은 패키지에서만 가능
	 * private:
	 *  
	 * Modifier 활용방법 : static, final(상수)
	 * static: 클래스 변수
	 * final: 수정 불가
	 */ 
	private String model;
	private int price;
	
	private static int count;
	private static final String COMPANY = "삼성";
	private static final String COMPANY2;
	final int speed;
	final int speed2=200;
	final int speed3;
	private final int speed4 = 400;
	
	static{
		COMPANY2 = "LG";
	}
	
	{
		speed3 = 300;
	}
	
	// 2. 생성자: 초기화 목적, overloading
	public Computer() {
		this(null, 0);
	}
	
	public Computer(String model) {
		this(model, 0);
	}

	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
		this.speed = 100;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public static int getCount() {
		return count;
	}
	
}
