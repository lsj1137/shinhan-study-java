package com.shinhan.day11.threads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String accNo;
	private String owner;
	private int balance;
	public void deposit(int amount) {
		balance += amount;
	}
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println("출금성공");
			return amount;
		}else {
			System.out.println("출금실패");
			return 0;
		}
	}

}
