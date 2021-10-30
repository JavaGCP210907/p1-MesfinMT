package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Status;
import com.revature.utils.HibernateUtil;

public class StatusDao {
	public Status getStatusById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Status ticketStatus = ses.get(Status.class, id);
		
		HibernateUtil.closeSession();
		
		return ticketStatus;
	}
	
public Status getStatusByStatus(String status) {
		
		Session ses = HibernateUtil.getSession();
		
		Status ticketStatus = (Status) ses.createQuery("FROM Status WHERE status = '" + status + "'").uniqueResult();
		
		HibernateUtil.closeSession();
		
		return ticketStatus;
	}
	
}
