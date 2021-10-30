package com.revature.daos;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.User;
import com.revature.models.Status;
import com.revature.models.Ticket;
import com.revature.models.Type;
import com.revature.utils.HibernateUtil;

public class TicketDao implements TicketInterface {
	

	@Override
	public List<Ticket> getAllTickets() {
		Session ses = HibernateUtil.getSession();
		
		List <Ticket> ticketList = ses.createQuery("From Ticket").list();
		
		HibernateUtil.closeSession();
		
		return ticketList;
		}

	@Override
	public Ticket getTicketsById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Ticket tickets = ses.get(Ticket.class, id);
			
		HibernateUtil.closeSession();
		
		return tickets;
	}

	public List<Ticket> getTicketsByUserId(int id) {
		Session ses = HibernateUtil.getSession();
		
		List<Ticket> tickets =ses.createQuery("FROM Ticket WHERE author = '" + id + "'").list();
			
		HibernateUtil.closeSession();
		
		return tickets;
	}

	@Override
	public void addTicket(Ticket ticket) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession(); 
		System.out.println("Mesfin After DB start");
		
		ses.save(ticket); 
		
		HibernateUtil.closeSession();
	}

	@Override
	public void addEmployee(User user) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession();
		System.out.println("Mesfin After DB start");
		ses.save(user); 
		
		HibernateUtil.closeSession();
	}

	public void updateStatus(Ticket ticket,User user,Status rStatus,String resolved) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		System.out.println("Mesfin After DB start");
		String HQL = "UPDATE Ticket SET status = '" + rStatus.getId() + "' , resolver  = '" + user.getId() +"' , resolved  = '" + resolved +"' WHERE id = " + ticket.getId();
		Query q = ses.createQuery(HQL);
		q.executeUpdate();
		tran.commit();
		HibernateUtil.closeSession();		}

	
	@Override
	public void updateTicket(Ticket ticket) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		System.out.println("Mesfin After DB start");
		String HQL = "UPDATE Ticket SET status = '" + ticket.getStatus() + "' WHERE id = " + ticket.getId();
		Query q = ses.createQuery(HQL);
		q.executeUpdate();
		tran.commit();
		HibernateUtil.closeSession();		}

	public void addStatus(Status status) {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(status); 
		
		HibernateUtil.closeSession();
	}

	@Override
	public void addType(Type type) {
		Session ses = HibernateUtil.getSession();
		
		ses.save(type); 
		
		HibernateUtil.closeSession();
	}

}
