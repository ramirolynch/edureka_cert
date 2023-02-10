package myCertification.bank.services;


import org.springframework.beans.factory.annotation.Autowired;
import myCertification.bank.dao.CreditCardDao;
import myCertification.bank.dto.CreditCard;


public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardDao dao;

	public void authorizeCreditCard(CreditCard cc) {

		int n = dao.authorizeCreditCard(cc);
		if (n > 0) {
			System.out.println("$$$--- Credit Card Authorized ---$$$");
		}
	}
	
	public CreditCard findCardByNumber(Long cc, Long cvv) {
		return dao.findCardByNumber(cc,cvv);
	}
}