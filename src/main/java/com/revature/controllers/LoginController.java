package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {
	UserService us=new UserService();
	LoginService ls = new LoginService();

	public Handler roleHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
		String body = ctx.body(); 
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		User user=ls.login(LDTO.getUsername(), LDTO.getPassword());
		Role x=user.getRole();
		String s=x.getRole();
		String JSONUser = gson.toJson(s);
		ctx.result(JSONUser);
			ctx.status(200);
		} else {
			ctx.status(401); 
			ctx.result("Login Failed! :(");
			
		}
	};
	
	public Handler usrHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
		String body = ctx.body(); 
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		User user=ls.login(LDTO.getUsername(), LDTO.getPassword());
		String JSONUser = gson.toJson(user);
		ctx.result(JSONUser);
			ctx.status(200);
		} else {
			ctx.status(401); 
			ctx.result("Login Failed! :(");
			
		}
	};
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); 
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		User user=ls.login(LDTO.getUsername(), LDTO.getPassword());
			if(user!=null) {
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			ctx.req.getSession(); 
			ctx.status(200);
			ctx.result(jwt);
		} else {
			ctx.status(401); 
			ctx.result("Login Failed! :(");
		}
	};
	
	public Handler logoutHandler = (ctx) -> {
		if(ctx.req.getSession() != null) {
			ctx.clearCookieStore();
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
}
