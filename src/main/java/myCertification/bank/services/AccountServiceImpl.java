package myCertification.bank.services;


import org.springframework.beans.factory.annotation.Autowired;

import myCertification.bank.dao.AccountDao;
import myCertification.bank.dto.Account;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;

	public void saveAccount(Account acc) {

		int n = dao.saveAccount(acc);
		if (n > 0) {
			System.out.println("$$$--- Account Saved ---$$$");
		}

	}
/*
	public void deleteAccountById(Long id) {
		Integer n = dao.deleteAccountById(id);
		if (n > 0)
			System.out.println("$$$--- Account Deleted ---$$$");
		else
			System.out.println("@@@--- No Matching Account to Delete ---@@@");
	}

	public Account getAccountById(Long id) {

		return dao.findAccountById(id);
	}

	public List<Account> getAllAccounts() {
		List<Account> accounts = dao.findAllAccounts();
		for (Account acc : accounts) {
			System.out.println(acc);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return accounts;

	}
	*/

}
