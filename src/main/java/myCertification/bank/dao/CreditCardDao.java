package myCertification.bank.dao;

import myCertification.bank.dto.CreditCard;


public interface CreditCardDao {
	
Integer authorizeCreditCard(CreditCard cc);

CreditCard findCardByNumber(Long cc, Long cvv);

}
