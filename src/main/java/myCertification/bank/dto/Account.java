package myCertification.bank.dto;

import java.util.Date;

public class Account {
	
	private Long id;
	private String name;
	private Date dateOfBirth;
	private String address;
	private String email;
	private String accountType;
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Account() {
		super();
	}
	public Account(String aname, Date dob, String address, String email, String type) {
	
		this.name = aname;
		this.dateOfBirth = dob;
		this.address = address;
		this.email = email;
		this.accountType = type;
	}
	public Account(String aname, Date dob, String address, String email, String type, Long userId) {
		
		this.name = aname;
		this.dateOfBirth = dob;
		this.address = address;
		this.email = email;
		this.accountType = type;
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", email=" + email + ", accountType=" + accountType + "]";
	}

}
