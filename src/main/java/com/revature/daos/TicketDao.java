package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.utils.HibernateUtil;

public class TicketDao implements TicketInterface {


	@Override
	public List<Ticket> getAllTickets() {
		Session ses = HibernateUtil.getSession();
		
		
		String hql = "from Ticket";
	//	Session session = entityManagerFactory.openSession();
		Query query = ses.createQuery(hql);
		List<Ticket> ticketList = query.getResultList(); 

		//Using HQL! Hibernate Query Language. It references Java Classes, not DB entities
//		List<Ticket> ticketList = ses.createNativeQuery("FROM Ticket").list();
	//	List<Ticket> ticketList = ses.get.;
		
		HibernateUtil.closeSession();
		
		return ticketList;
		}

	@Override
	public Ticket getTicketById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Ticket movie = ses.get(Ticket.class, id);
		
		HibernateUtil.closeSession();
		
		return movie;
	}

	@Override
	public void addTicket(Ticket ticket) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC
		System.out.println("Mesfin After DB start");
		
		ses.save(ticket); 
		
		HibernateUtil.closeSession();
	}

	@Override
	public void addEmployee(Employee employee) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC
		System.out.println("Mesfin After DB start");
		
		ses.save(employee); 
		
		HibernateUtil.closeSession();
	}

	
	@Override
	public void updateTicket(Ticket ticket) {
		System.out.println("Mesfin Before DB start");
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction(); //update and delete must happen within a transaction
		System.out.println("Mesfin After DB start");
		//updates and deletes take a little more work... You should put the query into a Query object
		//and then make sure to executeUpdate(), similar to in JDBC.
		
		//Assign the Query syntax to a String
		String HQL = "UPDATE Ticket SET status = '" + ticket.getStatus() + "' WHERE id = " + ticket.getId();
		
		//Instantiate a Query object with createQuery()
		Query q = ses.createQuery(HQL);
		
		//Send the update to the DB just like JDBC
		q.executeUpdate();
		
		//close transaction and session to prevent memory leak
		tran.commit();
		HibernateUtil.closeSession();		}

}
