package myCertification.bank.dao;

import myCertification.bank.dto.Transaction;

public interface TransactionDao {
	
    Integer saveCredit(Transaction tx);
    
    Integer saveDebit(Transaction tx);
    
    /*
	
	Integer updateAccount(Account acc);
	
	Integer deleteAccountById(Long id);
	
	Account findAccountById(Long id);
	
	List<Account> findAllAccounts();
*/

}
