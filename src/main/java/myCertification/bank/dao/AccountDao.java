package myCertification.bank.dao;

import myCertification.bank.dto.Account;

public interface AccountDao {
	
    Integer saveAccount(Account acc);
}
