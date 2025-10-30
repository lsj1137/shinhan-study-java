package com.shinhan.day06.accountApplication;

import java.util.Scanner;

// select, insert, update, delete (CRUD)
public class AccountDAO {
	private AccountDTO[] accList = new AccountDTO[100];
	private int seq;
	
	public AccountDTO[] selectAll() {
		return accList;
	}
	
	public String deposit(String acNum, int money) {
		String message = "계좌 예금 실패";
		for (AccountDTO ac: accList) {
			if (ac==null) continue;
			if (ac.getAccNo().equals(acNum)) {
				ac.setBalance(ac.getBalance()+money);
				message = "계좌 예금 성공";
				break;
			}
		}
		return message;
	}
	
	public String withdraw(String acNum, int money) {
		String message = "계좌 출금 실패";
		for (AccountDTO ac: accList) {
			if (ac==null) continue;
			if (ac.getAccNo().equals(acNum) && ac.getBalance()>=money) {
				ac.setBalance(ac.getBalance()-money);
				message = "계좌 출금 성공";
				break;
			} else if (ac.getAccNo().equals(acNum) && ac.getBalance()<money) {
				message = "계좌 잔고 부족";
				break;
			}
		}
		return message;
	}
	
	public String insert(AccountDTO acc) {
		accList[seq++] = acc;
		return seq + "번째 계좌가 등록됨";
	}
	public String update(AccountDTO acc) {
		String message = "계좌 수정 실패";
		for (int i=0; i<seq; i++) {
			if (accList[i]!=null && accList[i].getAccNo().equals(acc.getAccNo())) {
				accList[i].setOwner(acc.getOwner());
				accList[i].setBalance(acc.getBalance());
				message = "계좌 수정 성공";
			}
		}
		return acc.getAccNo() + message;
	}
	public String delete(String accNo) {
		String message = "계좌 삭제 실패";
		for (int i=0; i<seq; i++) {
			if (accList[i]!=null && accList[i].getAccNo().equals(accNo)) {
				accList[i] = null;
				message = "계좌 삭제 성공";
			}
		}
		return accNo + message;
	}
}
