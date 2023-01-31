package myCertification.bank.services;


import myCertification.bank.dto.Transaction;

    public interface TransactionService {
	
   
    public void saveCredit(Transaction tx);
    public void saveDebit(Transaction tx);
	
	/*
	public void deleteAccountById(Long id);
	
	public Account getAccountById(Long id);
	
	public List<Account> getAllAccounts();
	*/

}
    


