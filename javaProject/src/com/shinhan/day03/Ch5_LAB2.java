package com.shinhan.day03;

public class Ch5_LAB2 {

	public static void main(String[] args) {
		System.out.println("=========== Q1 ===========");
		q1();
		System.out.println("=========== Q2 ===========");
		q2();
	}
	
	public static String[] split(String str, char separator){
		String[] temp = new String[str.length()];
		int before = 0, arraySize = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i)==separator) {
				temp[arraySize++] = str.substring(before, i);
				before = i+1;
			}
		}
		temp[arraySize] = str.substring(before, str.length());
		String[] result = new String[arraySize+1];
		for (int i=0; i<arraySize+1;i++) {
			result[i] = temp[i];
		}
		return result;
	}

	private static void q2() {
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for(int i=0; i<addrArr.length; i++){
			System.out.print(addrArr[i] + " ");
		}
		
	}



	public static String myReplace(String str, char oldChar, char newChar) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == oldChar) {
				newStr += newChar;
			} else {
				newStr += str.charAt(i);
			}
		}
		return newStr;
	}

	public static void q1() {
		System.out.println("문자열에 특정문자 변경하는 테스트");
		System.out.println("-------------Sample 1 --------------");
		String str1 = myReplace("hello world", 'l', '*');
		System.out.println(str1);

		System.out.println("-------------Sample 2 --------------");
		String str2 = myReplace("hello world", ' ', '-');
		System.out.println(str2);

		System.out.println("-------------Sample 3 --------------");
		String str3 = myReplace("hello world", 'a', '*');
		System.out.println(str3);
	}
}
