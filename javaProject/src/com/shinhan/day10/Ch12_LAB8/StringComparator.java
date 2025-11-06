package com.shinhan.day10.Ch12_LAB8;

public class StringComparator {
	public static void main(String[] args) {
		StringComparator sc = new StringComparator();
		int result1 = sc.compare("Yongari-2001", "DragonWar", true);
		int result2 = sc.compare("Yongari-2001", "DragonWar", false);
		System.out.println(result1);// 12
		System.out.println(result2);// 9
	}
	
	private int compare(String string, String string2, boolean b) {
		if (b) return Math.max(string.length(), string2.length());
		int count1 = 0, count2 = 0;
		for (int i=0; i<string.length(); i++)
			if (string.charAt(i)=='a') count1++;
		
		for (int i=0; i<string2.length(); i++)
			if (string2.charAt(i)=='a') count2++;
		
		return count1>count2 ? string.length():string2.length();
	}
}
