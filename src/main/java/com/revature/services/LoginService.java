package com.revature.services;

public class LoginService {

	//hardcoding username/password - I don't want to create a whole users table/DAO ;P
	
	//Typically you'll want to validate user/pass against some user/pass in your database
		//So in your P1 you'dd be sending the data from the LoginDTO into the dao
		//And most likely doing some dao method that uses those values to check for matching values in the DB
		//where clause?
	
	public boolean login(String username, String password) {
		
		if(username.equals("ben") && password.equals("password")) {
			return true;
		}
		
		return false;
		
	}
	
}
