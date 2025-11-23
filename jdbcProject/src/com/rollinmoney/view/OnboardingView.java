package com.rollinmoney.view;

public class OnboardingView {
	public static void printTitle() {
		String titleArt = """
$$$$$$$\\   $$$$$$\\  $$\\   $$\\ 
$$  __$$\\ $$  __$$\\ $$$\\  $$ |
$$ |  $$ |$$ /  $$ |$$$$\\ $$ |
$$ |  $$ |$$ |  $$ |$$ $$\\$$ |
$$ |  $$ |$$ |  $$ |$$ \\$$$$ |
$$ |  $$ |$$ |  $$ |$$ |\\$$$ |
$$$$$$$  | $$$$$$  |$$ | \\$$ |
\\_______/  \\______/ \\__|  \\__|		
     돈... 굴러가유...""";
		System.out.println(titleArt);
	}
	
	public static void showIntroMenu() {
		System.out.println("\n=== 🏠 시작 메뉴 ===");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");
        System.out.print("선택 >> ");
	}

	public static void showMainMenu() {
		System.out.println("\n=== 📋 메인 메뉴 ===");
	    System.out.println("1. 💰 내 자산 조회");
	    System.out.println("2. 📈 주식 거래");
	    System.out.println("3. 🏦 은행 상품");
	    System.out.println("4. 📜 자산 변동 기록");
	    System.out.println("5. 🚪 로그아웃");
	    System.out.print("선택 >> ");
	}
}
