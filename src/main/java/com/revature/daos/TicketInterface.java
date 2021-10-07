package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;


public interface TicketInterface {
	public List<Ticket> getAllTickets();
	
	public Ticket getTicketById(int id);
	
	public void addTicket(Ticket ticket);
	
	public void addEmployee(Employee employee);
	
	public void updateTicket(Ticket ticket);

}
