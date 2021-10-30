package com.revature;


import java.util.List;

import org.hibernate.Session;

import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;
import com.revature.controllers.UserController;
import com.revature.daos.TicketDao;
import com.revature.models.User;
import com.revature.services.TicketService;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.Type;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		TicketDao tDao=new TicketDao();
		TicketController tc = new TicketController(); //to get access to the HTTP Handlers in the controller layer
		LoginController lc = new LoginController(); 
		UserController uc=new UserController();
		//testing whether our connection works...
//		try(Connection conn = ConnectionUtil.getConnection()){
//			System.out.println("hey there. old friend. you've connected to your database!");
//		} catch (SQLException e) {
//			System.out.println("hello old friend. your connection failed");
//			e.printStackTrace();
//		}
//		
		
		Role r1 = new Role("Manager");
		Role r2 = new Role("Employee");

		
		User e1 = new User("manager","pass","fname1","lname1","emp1@comp.com",r1);
		User e2 = new User("emp2","pass2","fname2","lname2","emp2@comp.com",r2);
		User e3 = new User("emp3","pass3","fname3","lname3","emp3@comp.com",r2);
		
		tDao.addEmployee(e1);
		tDao.addEmployee(e2);
		tDao.addEmployee(e3);
		
		Status s1 = new Status("Pending");
		Status s2 = new Status("Approved");
		Status s3 = new Status("Denied");
		
		tDao.addStatus(s1);
		tDao.addStatus(s2);
		tDao.addStatus(s3);
		
		Type t1 = new Type("LODGING");
		Type t2 = new Type("TRAVEL");
		Type t3 = new Type("FOOD");
		Type t4 = new Type("TRAINING");
		
		tDao.addType(t1);
		tDao.addType(t2);
		tDao.addType(t3);
		tDao.addType(t4);
		
		Ticket tk1 = new Ticket(700,"10-01-21","10-03-21","Travel expemse","REC001",e2,e1,s2,t2);
		Ticket tk2 = new Ticket(300,"10-02-21","10-04-21","Business expemse","REC002",e2,e1,s2,t4);
		Ticket tk3 = new Ticket(700,"10-03-21","10-05-21","Medical expemse","REC003",e2,e1,s3,t1);
		Ticket tk4 = new Ticket(400,"10-01-21","10-03-21","Travel expemse","REC004",e3,e1,s1,t3);
		Ticket tk5 = new Ticket(600,"10-02-21","10-04-21","Medical expemse","REC005",e3,e1,s1,t4);
		Ticket tk6 = new Ticket(1000,"10-03-21","10-05-21","Travel expemse","REC006",e3,e1,s3,t2);
		

		
		
		tDao.addTicket(tk1);
		tDao.addTicket(tk2);
		tDao.addTicket(tk3);
		tDao.addTicket(tk4);
		tDao.addTicket(tk5);
		tDao.addTicket(tk6);
		
		List<Ticket> allTickets = tDao.getAllTickets();
		
		for(Ticket t : allTickets) {
			System.out.println(t);
		}
		
//		
//		//updating movie
//		tk1.setStatus("Denied");
//		tk2.setStatus("Denied");
//		
//		tDao.updateTicket(tk1);
//		tDao.updateTicket(tk2);
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8040);
		
		//We use javalin to expose API endpoints, which HTTP can send Requests to, in order to get a Response 
		
		//GET all avengers
		//GET /avengers => return all Avengers
		app.get("/ticket", tc.getAllTicketsHandler);
		app.get("/ticket/:userid", tc.getTicketsByUserIdHandler);
		app.post("/role", lc.roleHandler);
		app.post("/usr", lc.usrHandler);
		app.post("/addticket", tc.addticketHandler);
		app.post("/approveticket", tc.approveticket);
			
		//imagine we have users 
		//Send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
		app.get("/logout", lc.logoutHandler);
		
		
		//below are handlers I won't implement, but should give you an idea of some you may need for P1------
		
		//app.get("/avengers/:id", dc.getAvengerByIdHandler);
        
		
        //app.post("/avengers", dc.createAvengerHandler);
        
		
        //app.delete("/avengers/:id", dc.deleteAvengerByIdHandler);
		
		
		
		
	}

}
