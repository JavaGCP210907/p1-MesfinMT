package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Ticket;
import com.revature.models.Type;
import com.revature.utils.HibernateUtil;

public class TypeDao {

	public Type getTypeById(String type) {
		
		Session ses = HibernateUtil.getSession();
		
		Type ticketType = (Type) ses.createQuery("FROM Type WHERE type = '" + type + "'").uniqueResult();
		
		HibernateUtil.closeSession();
		
		return ticketType;
	}
}
