package com.shinhan.day10.Ch12_LAB4;

public class Prob1 {

	public static void main(String[] args) {
		String fromStr = "everyday we have is one more than we deserve";
		String toStr = "";
		int salt = 3;
		for (char c : fromStr.toCharArray()) {
			if (c == ' ') {
				toStr += " ";
				continue;
			}
			char convertedChar = (char) (c + salt);
			if (convertedChar > 'z') {
				convertedChar -= 26;
			}
			toStr += convertedChar;
		}
		System.out.println(toStr);
	}

}
