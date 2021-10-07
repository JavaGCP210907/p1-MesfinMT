package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Ticket;
import com.revature.services.TicketService;

import io.javalin.http.Handler;

public class TicketController {

	TicketService rs = new TicketService(); 

	public Handler getAllTicketsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Ticket> allTickets = rs.getAllTickets();
		
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONTickets = gson.toJson(allTickets); //convert our Java object into a JSON String
		
		ctx.result(JSONTickets); //return our Avengers
		ctx.body();
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
		
	};


	
}
