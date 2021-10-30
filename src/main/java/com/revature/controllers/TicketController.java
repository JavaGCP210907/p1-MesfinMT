package com.revature.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.revature.daos.TicketDao;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.TicketDTO;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.services.TicketService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class TicketController {

	TicketService ts = new TicketService(); 
	UserService us=new UserService();
	TicketDao tDao=new TicketDao();
	
	public Handler getAllTicketsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Ticket> allTickets = ts.getAllTickets();
		
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


	public Handler getTicketsByUserIdHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { 
			int id=Integer.parseInt(ctx.pathParam("userid"));
		List<Ticket> allTickets = ts.getTicketsByuserId(id);
		
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
	
	
	public Handler addticketHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { 

			String body = ctx.body();
//			String username = (String)ctx.req.getSession(true).getAttribute("username");
			
			Gson gson = new Gson();
			
			TicketDTO rDTO = gson.fromJson(body, TicketDTO.class);
			Type rType = ts.getTypeById(rDTO.getType());
			Status rStatus = ts.getStatusById(1);
			User user = us.getUserById(rDTO.getUserid());
		    Timestamp timestamp = new Timestamp(new Date().getTime());
		    String submitted = timestamp.toString();

			Ticket r = new Ticket(rDTO.getAmount(),submitted, rDTO.getDescription(), user, rStatus, rType);
			ts.submit(r);
			ctx.status(200);
			
			
		} else {
			ctx.status(403);
		}

	};
	
	public Handler approveticket = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { 

			String body = ctx.body();
//			String username = (String)ctx.req.getSession(true).getAttribute("username");
			
			Gson gson = new Gson();
			
			TicketDTO rDTO = gson.fromJson(body, TicketDTO.class);
			Ticket ticket = ts.getTicketById(rDTO.getTicket_id());
			Status rStatus = ts.getStatusByStatus(rDTO.getStatus());
			User user = us.getUserById(rDTO.getUserid());
		    Timestamp timestamp = new Timestamp(new Date().getTime());
		    String resolved = timestamp.toString();
		    System.out.println(rDTO.getTicket_id()+" "+rDTO.getStatus()+" "+rDTO.getUserid());
		    System.out.println(ticket+" "+rStatus+" "+user);
		    tDao.updateStatus(ticket,user,rStatus,resolved);

			ctx.status(200);
			
			
		} else {
			ctx.status(403);
		}

	};
}
