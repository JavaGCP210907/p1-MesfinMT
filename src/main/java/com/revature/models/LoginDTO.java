package com.revature.models;

//What the HECK is a DTO? Data Transfer Object. A DTO is just a model of /some/ data coming from the client
//An HTTP handler will parse a JSON object sent by the user, containing their username and password
//this then gets sent to the controller to get turned into a Java object
//The username and password will be put into the DTO as fields, which will then get checked/validated by the service layer
//You NEVER store a DTO in the database. It's purely for Data Transfer... hence Data Transfer Object
public class LoginDTO {

	//our LoginDTO models only the username/password of our users
	private String username;
	private String password;
	
	
	//then I just want two constructors so we can instantiate this class when needed
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//and then getters/setters to access our fields
	
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
	
}
