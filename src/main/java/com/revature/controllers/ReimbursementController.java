package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {

	ReimbursementService rs = new ReimbursementService(); 

	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Reimbursement> allReimbursements = rs.getAllReimbursements();
		
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONReimbursements = gson.toJson(allReimbursements); //convert our Java object into a JSON String
		
		ctx.result(JSONReimbursements); //return our Avengers
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
		
	};


	
}
