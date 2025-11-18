package com.shinhan.day16.final_test;
class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge {
	/*
	 * user : String : private : 폰사용자이름 call : int : private : 통화시간(분단위) sms : int :
	 * private : 문자전송건수 data : int : private : 데이터통신량(GB단위) total : int : private :
	 * 통신요금(원)
	 */
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;

	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharge() {
		int callFee = 10, smsFee = 20, dataFee = 1000;
		if (call >= 200) {
			callFee *= 2;
		}
		if (sms >= 300) {
			smsFee *= 4;
		}
		if (data >= 7) {
			dataFee *= 2;
		}
		total = callFee * call + smsFee * sms + dataFee * data;
		return total;
	}

	public void printCharge() {
		total = calcCharge();
		System.out.printf("%s 사용자는 이번달에 사용하신 전화요금이 %d 원입니다.\n", user, total);
	}

}
