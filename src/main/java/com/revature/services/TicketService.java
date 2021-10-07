package com.revature.services;

import java.util.List;

import com.revature.daos.TicketDao;
import com.revature.models.Ticket;


public class TicketService {

	//instantiate an AvengerDAO to use its method
	TicketDao rDao = new TicketDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<Ticket> getAllTickets() {
		return rDao.getAllTickets();
	}


	
	//all we're doing is calling the dao method in order to get a List of all the Avengers to send to the controller

}
