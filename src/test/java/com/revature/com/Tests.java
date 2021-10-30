package com.revature.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;

public class Tests {
	public static LoginService ls=new LoginService();
	public static UserDao uDao = new UserDao();
	public static UserService rgs = new UserService();
	public static User us=new User();

	@BeforeAll 
	public static void createCalc() {
		System.out.println("In the @BeforeAll method");
	}
	
	@AfterAll 
	public static void clearCalc() {
		System.out.println("In the @AfterAll method");
		us=null;
	}
	
//	@Tests
	public void testCorrectLogin() {
		System.out.println("Testing Successsful User Login");
		System.out.println();
		assertEquals(ls.login("username", "password"),uDao.getUserRoles("username"));
	}

}
