package myCertification.bank.dto;


public class CreditCard {
	
	private Long id;
	private Long cardNumber;
	private Long cvv;
	private Long amount;
	
	public CreditCard() {
		super();
	}

	public CreditCard(Long cardNumber, Long cvv, Long amount) {
		super();
		this.setCardNumber(cardNumber);
		this.setCvv(cvv);
		this.setAmount(amount);
	}

	public CreditCard(Long cardNumber, Long cvv) {
		super();
		this.setCardNumber(cardNumber);
		this.setCvv(cvv);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", amount=" + amount + "]";
	}

}