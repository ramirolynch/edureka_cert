package myCertification.bank.services;


import myCertification.bank.dto.CreditCard;

    public interface CreditCardService {
	 
    public void authorizeCreditCard(CreditCard cc);
    
    public CreditCard findCardByNumber(Long cc, Long cvv);
  
}
    