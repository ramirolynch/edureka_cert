package myCertification.bank.dto;

import java.util.Date;

public class Transaction {
	private Long id;
	
	
	public Transaction() {
		super();
	}

	public Transaction(Date dateTx, String description, Long amount, Long accountFrom, Long userId) {
		super();
		this.dateTx = dateTx;
		this.description = description;
		this.amount = amount;
		this.accountFrom = accountFrom;
		this.userId = userId;
	}
	
	public Transaction(Date dateTx, String description, Long amount, Long accountTo, Long accountFrom, Long userId) {
		super();
		this.dateTx = dateTx;
		this.description = description;
		this.amount = amount;
		this.accountTo = accountTo;
		this.accountFrom = accountFrom;
		this.userId = userId;
	}
	
	private Date dateTx;
	private String description;
	private Long amount;
	private Long accountTo;
	private Long accountFrom;
	private Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateTx() {
		return dateTx;
	}
	public void setDate(Date dateTx) {
		this.dateTx = dateTx;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Long accountTo) {
		this.accountTo = accountTo;
	}
	public Long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Long accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + dateTx + ", description=" + description + ", accountTo=" + accountTo
				+ ", accountFrom=" + accountFrom + ", userId=" + userId + "]";
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
