package com.shinhan.day16.final_test;
public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		int maxScore = 0;
		String maxName = "";
		for (String data : array) {
			String strScore = "";
			String name = "";
			for (char c : data.toCharArray()) {
				if (c == '점')
					continue;
				else if (Character.isDigit(c)) {
					strScore += c;
				} else {
					name += c;
				}
			}
			int score = Integer.valueOf(strScore);
			if (score > maxScore) {
				maxScore = score;
				maxName = name;
			}

		}
		System.out.printf("최고점수는 %s님 %d점 입니다.", maxName, maxScore);
	}
}
