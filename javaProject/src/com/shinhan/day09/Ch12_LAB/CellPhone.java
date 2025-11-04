package com.shinhan.day09.Ch12_LAB;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(of = {"model"})
@RequiredArgsConstructor
public class CellPhone {
	String model; // 핸드폰 모델 번호
	double battery; // 남은 배터리 양

	CellPhone(String model) {
		this.model = model;
	}// 모델 번호를 인자로 받는 생성자

	void call(int time) {
		try {
			if (time<0) throw new IllegalArgumentException("통화시간 입력오류");
			System.out.println("통화 시간 : "+time+"분");
			battery -= time * 0.5;
			if (battery < 0) {
				battery = 0;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리양을 감소시킨다.
		// 감소되는 배터리 양 = 통화시간(분) * 0.5
		// 배터리 양은 0보다 작아지지 않는다.
		// 통화 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“통화시간입력오류”)을 발생시킨다.

	void charge(int time) {
		try {
			if (time<0) throw new IllegalArgumentException("충전시간 입력오류");
			System.out.println("충전 시간 : "+time+"분");
			battery += time * 3;
			if (battery > 100) {
				battery = 100;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리양을 증가시킨다.
		// 충전되는 배터리 양 = 충전시간(분) * 3
		// 배터리 양은 100까지만 증가한다.
		// 충전 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.

	void printBattery() {
		System.out.println("남은 배터리 양 : "+battery);
	}// 남은 배터리 양을 출력한다.

//	public boolean equals(Object otherObject) {
//		return otherObject instanceof CellPhone && ((CellPhone)otherObject).model.equals(model);
//	}
}
