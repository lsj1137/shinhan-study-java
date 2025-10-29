package com.shinhan.day05;

public class CustomerManager {
	int MAX_NUM = 100;
	Customer[] customers = new Customer[MAX_NUM];
	int seq = 0;
	
	//CRUD
	void insert(Customer cust) {
		customers[seq++] = cust;
	}
	
	void selectAll() {
		if (seq==0) {
			System.out.println("고객 정보가 없습니다.");
			return;
		}
		for (Customer cust:customers) {
			if (cust==null) break;
			System.out.println(cust);
		}
	}
	
	void selectCondition(String level) {
		for (Customer cust:customers) {
			if (cust==null) break;
			if (cust.level.toString().equals(level.toUpperCase())) {
				System.out.println(cust);
			}
		}
	}
	
	void selectCondition2(String phoneNum) {
		for (Customer cust:customers) {
			if (cust==null) break;
			if (cust.phoneNum.equals(phoneNum)) {
				System.out.println(cust);
			}
		}
	}
	
	void update(int id, String name, String phoneNum) {
		for (Customer cust:customers) {
			if (cust.id==id) {
				cust.name = name;
				cust.phoneNum = phoneNum;
				System.out.println("수정이 완료되었습니다.");
				return;
			}
		}
		System.out.println("수정에 실패했습니다.");
	}
	
	void delete(int id) {
		for (int i=0; i<MAX_NUM; i++) {
			if (customers[i].id==id) {
				customers[i] = null;
				System.out.println("삭제가 완료되었습니다.");
				return;
			}
		}
		System.out.println("삭제에 실패했습니다.");
	}

}