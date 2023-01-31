package myCertification.bank.services;

import org.springframework.beans.factory.annotation.Autowired;

import myCertification.bank.dao.TransactionDao;
import myCertification.bank.dto.Transaction;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDao dao;

	public void saveCredit(Transaction tx) {

		int n = dao.saveCredit(tx);
		if (n > 0) {
			System.out.println("$$$--- Transaction Credit Saved ---$$$");
		}
	}
		
	public void saveDebit(Transaction tx) {

		int n = dao.saveDebit(tx);
		if (n > 0) {
			System.out.println("$$$--- Transaction Debit Saved ---$$$");
		}
	}

}




