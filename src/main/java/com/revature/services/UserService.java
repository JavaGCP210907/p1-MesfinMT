package com.revature.services;


import com.revature.daos.UserDao;
import com.revature.models.User;

public class UserService {
	UserDao uDao = new UserDao();

	
	public User getUserById(int id) {
		return uDao.getUserById(id);
		}

	public User getUserRoles(String username) {
		return uDao.getUserRoles(username);
		}

}
