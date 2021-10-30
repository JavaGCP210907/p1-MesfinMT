package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Ticket;
import com.revature.models.User;
import com.revature.services.TicketService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {

	UserService us = new UserService(); 

	public Handler getUserRoles = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { 
		String username = ctx.queryParam("username");
		User uname = us.getUserRoles(username);
		Gson gson = new Gson();
		String JSONusername = gson.toJson(uname); 
		ctx.result(JSONusername); 
		ctx.body();
		ctx.status(200); 
		} else {
			ctx.status(403); 
		}
		
	};
}
