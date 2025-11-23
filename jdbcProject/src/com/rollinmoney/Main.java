package com.rollinmoney;

import java.util.List;

import com.rollinmoney.constant.Messages;
import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;
import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.service.HoldingService;
import com.rollinmoney.service.MemberService;
import com.rollinmoney.service.StockService;
import com.rollinmoney.util.IOUtil;
import com.rollinmoney.view.BankView;
import com.rollinmoney.view.HoldingView;
import com.rollinmoney.view.OnboardingView;
import com.rollinmoney.view.StockView;

//import com.rollinmoney.util.StockDataInitializer;

public class Main {

	private static Long loggedInMemberId = 0L;
	static MemberDTO member = null;
	private static MemberService memberService = new MemberService();
	private static HoldingService holdingService = new HoldingService();
	private static StockService stockService = new StockService();

	public static void main(String[] args) {
//		StockDataInitializer.init(); // 주식 데이터 디비에 입력
		OnboardingView.printTitle();

		while (true) {
			if (loggedInMemberId == 0) {
				introMenu();
			} else {
				mainMenu();
			}
		}
	}

	static void introMenu() {
		OnboardingView.showIntroMenu();
		int cmd = IOUtil.inputInt();
		// 1. 로그인 | 2. 회원가입 | 3. 종료
		switch (cmd) {
		case 1 -> login();
		case 2 -> register();
		case 3 -> terminate();
		default -> System.out.println(Messages.WRONG_INPUT);
		}
	}

	static void mainMenu() {
		member = memberService.refresh(loggedInMemberId);
		OnboardingView.showMainMenu();
		int cmd = IOUtil.inputInt();
		// 1. 내 자산조회 | 2. 주식 메뉴 | 3. 은행 메뉴 | 4. 자산 변동 기록 | 5. 로그아웃
		switch (cmd) {
		case 1 -> HoldingView.printHoldings(member, holdingService.getAllHoldings(loggedInMemberId));
		case 2 -> stockMenu();
		case 3 -> bankMenu();
		case 4 -> System.out.println(">> [변동 기록] 기능은 아직 공사 중이에요 🚧");
		case 5 -> logout();
		default -> System.out.println(Messages.WRONG_INPUT);
		}
	}

	private static void stockMenu() {
		// 1. 주식 조회 | 2. 주식 매수 | 3. 주식 매도 | 4. 뒤로 가기(메인 메뉴)
		sm: while (true) {
			StockView.showStockMenu();
			int cmd = IOUtil.inputInt();
			switch (cmd) {
			case 1 -> stockSearchMenu();
			case 2 -> buyStock();
			case 3 -> sellStock();
			case 4 -> {
				break sm;
			}
			default -> System.out.println(Messages.WRONG_INPUT);
			}
		}
	}

	private static void stockSearchMenu() {
		// 1. 국장 조회 | 2. 미장 조회 | 3. 주식명으로 조회 | 4. 티커로 조회 | 5. 뒤로 가기(주식 메뉴)
		ssm: while (true) {
			StockView.showStockSearchMenu();
			int cmd = IOUtil.inputInt();
			switch (cmd) {
			case 1 -> StockView.printStockList(stockService.getKorStocks());
			case 2 -> StockView.printStockList(stockService.getUSStocks());
			case 3 -> {
				System.out.print("찾고 싶은 주식 이름 입력 >> ");
				String name = IOUtil.inputStr();
				StockView.printStockList(stockService.findByName(name));
			}
			case 4 -> {
				System.out.print("찾고 싶은 주식 티커 입력 >> ");
				String ticker = IOUtil.inputStr();
				StockView.printStockList(stockService.findByTicker(ticker));
			}
			case 5 -> {
				break ssm;
			}
			default -> System.out.println(Messages.WRONG_INPUT);
			}
		}
	}

	private static void bankMenu() {
		BankView.showBankMenu();

	}

	private static void login() {
		System.out.print("ID를 입력하세요 (숫자): ");
		Long inputId = (long) IOUtil.inputInt();

		if (inputId == -1)
			return;

		member = memberService.login(inputId);

		if (member != null) {
			loggedInMemberId = member.getMemberId();
			System.out
					.println("✅ 로그인 성공!\n" + "환영합니다 " + member.getName() + "님.\n현재 잔고는 " + member.getCash() + "원입니다.");
		}
	}

	private static void register() {
		System.out.print("사용하실 이름을 입력하세요: ");
		String name = IOUtil.inputStr();

		Long newId = memberService.register(name);

		if (newId != null) {
			System.out.println("🎉 회원가입이 완료되었습니다!");
			System.out.println("👉 회원님의 ID는 [" + newId + "] 입니다.");
			System.out.println("   (로그인 시 필요하니 꼭 기억해 주세요!)");
		} else {
			System.out.println("❌ 회원가입에 실패했습니다.");
		}
	}

	private static void logout() {
		loggedInMemberId = 0L;
		member = null;
		System.out.println(Messages.LOGOUT);
	}

	private static void terminate() {
		System.out.println(Messages.GOOD_BYE);
		System.exit(0);
	}

	private static void buyStock() {
		StockDTO stockToBuy = null;
		System.out.print("매수할 주식의 티커 >> ");
		String ticker = IOUtil.inputStr();
		List<StockDTO> stockList = stockService.findByTicker(ticker);
		if (stockList.size() == 1) {
			stockToBuy = stockList.get(0);
		} else if (stockList.size() > 0) {
			StockView.printStockList(stockList);
			System.out.print("이 중 구매할 항목의 티커를 정확히 입력해주십시오 >> ");
			String ticker2 = IOUtil.inputStr();
			for (StockDTO stock : stockList) {
				if (stock.getTicker().equals(ticker2)) {
					stockToBuy = stock;
				}
			}
		}
		if (stockToBuy == null) {
			System.out.println("구매할 항목이 존재하지 않습니다.");
			return;
		}
		System.out.println("다음 항목을 구매합니다.");
		StockView.printStock(stockToBuy);
		System.out.print("구매할 수량 (취소 하려면 음수 입력) >> ");
		int quantity = IOUtil.inputInt();
		if (quantity < 0)
			return;
		
		System.out.println(holdingService.buyStock(member, stockToBuy, quantity));
	}

	private static void sellStock() {
		StockDTO stockToSell = null;
		HoldingDTO holdingToSell = null;
		List<HoldingDTO> holdingStockList = holdingService.getAllStocks(loggedInMemberId);
		List<StockDTO> stockInfos = stockService.getPersonalStocks(holdingStockList);
		HoldingView.printStocks(holdingStockList, stockInfos);
		System.out.print("매도할 주식의 티커를 입력하세요 >> ");
		String ticker = IOUtil.inputStr();
		for (StockDTO stockInfo : stockInfos) {
			if (stockInfo.getTicker().equals(ticker)) {
				stockToSell = stockInfo;
			}
		}
		if (stockToSell == null) {
			System.out.println("매도할 항목이 존재하지 않습니다.");
			return;
		}
		for (HoldingDTO holding: holdingStockList) {
			if (holding.getProductId()==stockToSell.getProductId()) {
				holdingToSell = holding;
				break;
			}
		}
		if (holdingToSell == null) {
			System.out.println("매도할 항목을 보유하고 있지 않습니다.");
			return;
		}
		System.out.println("다음 항목을 매도합니다.");
		StockView.printStock(stockToSell);
		System.out.print("매도할 수량 (현재 보유: "+holdingToSell.getQuantity()+") (취소 하려면 음수 입력) >> ");
		int quantity = IOUtil.inputInt();
		if (quantity < 0 || quantity > holdingToSell.getQuantity())
			return;
		
		System.out.println(holdingService.sellStock(member, stockToSell, holdingToSell, quantity));
	}
}
