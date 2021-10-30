package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class LoginService {
	public User login(String username, String password) {
		
		UserDao uDao = new UserDao();	
			if (uDao.getUserLogin(username, password)) {
				return uDao.getUserRoles(username);
			}
			
			return null;	
		}
}
