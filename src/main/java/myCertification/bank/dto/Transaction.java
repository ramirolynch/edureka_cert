package myCertification.bank.dto;

import java.util.Date;

public class Transaction {
	private Long id;
	
	
	public Transaction() {
		super();
	}

	public Transaction(Date date, String description, Long amount, Long accountFrom, Long userId) {
		super();
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.accountFrom = accountFrom;
		this.userId = userId;
	}
	
	private Date date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
		return "Transaction [id=" + id + ", date=" + date + ", description=" + description + ", accountTo=" + accountTo
				+ ", accountFrom=" + accountFrom + ", userId=" + userId + "]";
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
