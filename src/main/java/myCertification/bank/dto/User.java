package myCertification.bank.dto;



public class User {
	private Long id;
	private String password;

	public User() {
	}

	public User(Long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
