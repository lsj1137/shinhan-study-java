package com.shinhan.day09;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를 10번 던져서 같은 눈이 나온 횟수 : " + result1);
		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를 -10번 던져서 같은 눈이 나온 횟수 : " + result2);

	}

	//면이 8개인 주사위 2개를 생성한다.
	//주사위 2개를 동시에 n번 던졌을 때, 같은 눈이 나오는s 횟수를 계산한다.
	//주사위를 던지는 횟수(n)의 값에 음수가 들어오면 IllegalArgumentException을 발생시킴
	int countSameEye(int n) {
		try {
			if (n<0) throw new IllegalArgumentException("음수 횟수만큼 시도는 불가능 합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = 0;
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		for (int i=0; i<n; i++) {
			if (d1.play() == d2.play()) {
				result += 1;
			}
		}
		return result;
	}
}