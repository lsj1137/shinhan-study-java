package com.rollinmoney.controller;

import java.util.Scanner;

import com.rollinmoney.view.OnboardingView;

public class FrontController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		OnboardingView.printTitle();
		while (isRunning) {
			int job = Integer.parseInt(sc.nextLine());
			switch (job) {
			case 1->{}
			case 99 -> isRunning = false;
			}
		}
		

	}

}
