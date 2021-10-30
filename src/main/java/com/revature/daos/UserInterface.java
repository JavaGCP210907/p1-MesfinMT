package com.revature.daos;

import com.revature.models.User;

public interface UserInterface {

	public User getUserRoles(String username);

	boolean getUserLogin(String username, String password);
}
