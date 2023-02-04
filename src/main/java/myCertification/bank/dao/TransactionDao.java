package myCertification.bank.dao;

import java.util.List;

import myCertification.bank.dto.Transaction;

public interface TransactionDao {
	
    Integer saveCredit(Transaction tx);
    
    Integer saveDebit(Transaction tx);
    
    List<Transaction> findAllTransactionsByUserId(Long user_id);

}
