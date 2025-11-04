package com.shinhan.day09.Ch12_LAB02;

public class OverridingTest {
	public static void main(String args[]) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s1 = new String("30");
		System.out.println(ms1);
		System.out.println(ms1.toString());
		if (ms1.equals(ms2))
			System.out.println("ms1 과 ms2 의 합계는 동일합니다."); // OK
		else
			System.out.println("ms1 과 ms2 의 합계는 동일하지않습니다.");
		if (ms1.equals(s1))
			System.out.println("ms1 과 s1 의 합계는 동일합니다.");
		else
			System.out.println("ms1 과 s1 의 합계는 동일하지않습니다.");// OK
	}

}

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	/* 조건1 */
	@Override
	public String toString() {
		return Integer.toString(first + second);
	}

	/* 조건2 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MySum && this.toString().equals(((MySum) obj).toString());
	}
}
