package com.revature;


import java.util.List;

import org.hibernate.Session;

import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;
import com.revature.daos.TicketDao;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.Type;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		TicketDao tDao=new TicketDao();
		
		TicketController rc = new TicketController(); //to get access to the HTTP Handlers in the controller layer
		LoginController lc = new LoginController(); 
		
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

		
		Employee e1 = new Employee("emp1","pass1","fname1","lname1","emp1@comp.com",r1);
		Employee e2 = new Employee("emp2","pass2","fname2","lname2","emp2@comp.com",r2);
		Employee e3 = new Employee("emp3","pass3","fname3","lname3","emp3@comp.com",r2);
		
		tDao.addEmployee(e1);
		tDao.addEmployee(e2);
		tDao.addEmployee(e3);
		
		Ticket tk1 = new Ticket(700,"10-01-21","10-03-21","Travel expemse","REC001",2,1,"Approved","Travel");
		Ticket tk2 = new Ticket(300,"10-02-21","10-04-21","Business expemse","REC002",2,1,"Approved","Business");
		Ticket tk3 = new Ticket(700,"10-03-21","10-05-21","Medical expemse","REC003",2,1,"Denied","Medical");
		Ticket tk4 = new Ticket(400,"10-01-21","10-03-21","Travel expemse","REC004",3,1,"Pending","Business");
		Ticket tk5 = new Ticket(600,"10-02-21","10-04-21","Medical expemse","REC005",3,1,"Pending","Medical");
		Ticket tk6 = new Ticket(1000,"10-03-21","10-05-21","Travel expemse","REC006",3,1,"Denied","Travel");
		

		
		
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
		
		//finding movie by id
		System.out.println(tDao.getTicketById(1));
//		
//		//updating movie
		tk1.setStatus("Denied");
		tk2.setStatus("Denied");
		
		tDao.updateTicket(tk1);
		tDao.updateTicket(tk2);
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8040);
		
		//We use javalin to expose API endpoints, which HTTP can send Requests to, in order to get a Response 
		
		//GET all avengers
		//GET /avengers => return all Avengers
		app.get("/ticket", rc.getAllTicketsHandler);
		
		//imagine we have users 
		//Send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
		
		
		//below are handlers I won't implement, but should give you an idea of some you may need for P1------
		
		//app.get("/avengers/:id", dc.getAvengerByIdHandler);
        
		
        //app.post("/avengers", dc.createAvengerHandler);
        
		
        //app.delete("/avengers/:id", dc.deleteAvengerByIdHandler);
		
		
		
		
	}

}
