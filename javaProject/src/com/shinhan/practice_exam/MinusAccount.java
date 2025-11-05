package com.shinhan.practice_exam;

public class MinusAccount {
	public static int run(int m, int[] ledger) {
		int result = 0;
		int balance = 0;
		for (int l : ledger) {
			if (l >= 0) {
				balance += l;
			} else if (balance + l >= -m) {
				balance += l;
			}
		}
		result = balance;
		return result;
	}
}
