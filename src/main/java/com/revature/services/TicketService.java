package com.revature.services;

import java.util.List;

import com.revature.daos.StatusDao;
import com.revature.daos.TicketDao;
import com.revature.daos.TypeDao;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.Type;


public class TicketService {

	//instantiate an AvengerDAO to use its method
	TicketDao tDao = new TicketDao();
	TypeDao tyDao=new TypeDao();
	StatusDao stDao=new StatusDao();
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<Ticket> getAllTickets() {
		return tDao.getAllTickets();
	}

	public List<Ticket> getTicketsByuserId(int id) {
		return tDao.getTicketsByUserId(id);
	}

	public Ticket getTicketById(int id) {
		return tDao.getTicketsById(id);
	}

	public void addTicket(Ticket ticket) {
		tDao.addTicket(ticket);		
	}
	
	public Type getTypeById(String type) {
		Type rt = tyDao.getTypeById(type);
		return rt;
	}
	
	public Status getStatusById(int id) {
		Status rs = stDao.getStatusById(id);
		return rs;
	}
	public Status getStatusByStatus(String status) {
		Status rs = stDao.getStatusByStatus(status);
		return rs;
	}
	public void submit(Ticket r) {
		tDao.addTicket(r);
	}

}
