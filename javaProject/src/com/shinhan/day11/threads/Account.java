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
public class Account implements Comparable<Account>{
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
	@Override
	public int compareTo(Account o) {
		if (accNo.compareTo(o.accNo)==0 && owner.compareTo(o.owner)==0) return o.balance-balance;
		if (accNo.compareTo(o.accNo)==0) return owner.compareTo(o.owner);
		return accNo.compareTo(o.accNo);
	}

}
