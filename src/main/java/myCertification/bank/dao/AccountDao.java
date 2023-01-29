package myCertification.bank.dao;

import java.util.List;

import myCertification.bank.dto.Account;



public interface AccountDao {
	
    Integer saveAccount(Account acc);
    /*
	
	Integer updateAccount(Account acc);
	
	Integer deleteAccountById(Long id);
	
	Account findAccountById(Long id);
	
	List<Account> findAllAccounts();
*/
}
