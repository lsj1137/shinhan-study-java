package com.shinhan.day06.accountApplication;

// 업무 로직
// Controller의 요청을 받아서 처리
// DB관련 업무는 DAO에 할당
public class AccountService {
	private AccountDAO dao = new AccountDAO();
	
	public AccountDTO[] selectAllService() {
		return dao.selectAll();
	}
	public String insertService(AccountDTO acc) {
		return dao.insert(acc);
	}
	public String updateService(AccountDTO acc) {
		return dao.update(acc);
	}
	private String deleteService(String accNo) {
		return dao.delete(accNo);
	}
	public String deposit(String acNum, int money) {
		return dao.deposit(acNum, money);
	}
	public String withdraw(String acNum, int money) {
		return dao.withdraw(acNum, money);
	}
	
}
