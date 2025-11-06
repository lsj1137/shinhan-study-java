package com.shinhan.day11;

public class HomeAgency implements Rentable<Home>{

	@Override
	public Home rent() {
		return new Home();
	}
	
}
