package com.revature.models;

public class LoginDTO {

	private String username;
	private String password;
	private int role;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	

	
}
