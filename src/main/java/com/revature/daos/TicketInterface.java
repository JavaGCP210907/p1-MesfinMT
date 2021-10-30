package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.Type;


public interface TicketInterface {
	public List<Ticket> getAllTickets();
	
	public void addTicket(Ticket ticket);
	
	public void addStatus(Status status);
	public void addType(Type type);
	public void addEmployee(User user);
	
	public void updateTicket(Ticket ticket);

	public Ticket getTicketsById(int id);

}
