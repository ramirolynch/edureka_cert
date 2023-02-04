package myCertification.bank.services;


import java.util.List;

import myCertification.bank.dto.Transaction;

    public interface TransactionService {
	
   
    public void saveCredit(Transaction tx);
    public void saveDebit(Transaction tx);
    public List<Transaction> findAllTransactionsByUserId(Long user_id);
	
	/*
	public void deleteAccountById(Long id);
	
	public Account getAccountById(Long id);
	
	public List<Account> getAllAccounts();
	*/

}
    


