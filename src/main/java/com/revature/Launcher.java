package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		ReimbursementController rc = new ReimbursementController(); //to get access to the HTTP Handlers in the controller layer
		LoginController lc = new LoginController(); 
		
		//testing whether our connection works...
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("hey there. old friend. you've connected to your database!");
		} catch (SQLException e) {
			System.out.println("hello old friend. your connection failed");
			e.printStackTrace();
		}
		
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8040);
		
		//We use javalin to expose API endpoints, which HTTP can send Requests to, in order to get a Response 
		
		//GET all avengers
		//GET /avengers => return all Avengers
		app.get("/reimbursement", rc.getAllReimbursementsHandler);
		
		//imagine we have users 
		//Send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
		
		
		//below are handlers I won't implement, but should give you an idea of some you may need for P1------
		
		//app.get("/avengers/:id", dc.getAvengerByIdHandler);
        
		
        //app.post("/avengers", dc.createAvengerHandler);
        
		
        //app.delete("/avengers/:id", dc.deleteAvengerByIdHandler);
		
		
		
		
	}

}
