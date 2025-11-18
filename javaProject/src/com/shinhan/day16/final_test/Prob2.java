package com.shinhan.day16.final_test;
public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));
		
	}

	public static String leftPad(String str, int size, char fillChar) {
		String newStr = "";
		try {
			if (str.length() > size) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}
			int padLen = size - str.length();
			for (int i = 0; i < padLen; i++) {
				newStr += fillChar;
			}
			newStr += str;
		} catch (IllegalSizeException e) {
			newStr = e.getMessage();
		}
		return newStr;
	}

}

//구현하시오.
class IllegalSizeException extends Exception {

	public IllegalSizeException(String string) {
		super(string);
	}
}
