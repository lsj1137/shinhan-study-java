package com.shinhan.day06;

public class ShopService {
	
	private static ShopService instance;
	
	private ShopService() {	}
	
	public static ShopService getInstance() {
		if (instance==null) instance = new ShopService();
		return instance;
	}
}
