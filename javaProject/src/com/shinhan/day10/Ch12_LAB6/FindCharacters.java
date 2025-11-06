package com.shinhan.day10.Ch12_LAB6;

public class FindCharacters {
	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		int count = fc.countChar("Boys, be ambitious", 'b');
		System.out.println(count);
	}

	public int countChar(String str, char finding) {
		int result = 0;
		for (char c: str.toCharArray()) {
			if (c==finding) result++; 
		}
		return result;
	}

}
