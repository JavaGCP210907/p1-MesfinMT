package com.revature.daos;

import org.hibernate.Session;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserInterface {

	@Override
	public boolean getUserLogin(String username, String password) {
        
        Session ses = HibernateUtil.getSession();
		User user = (User) ses.createQuery("FROM User WHERE username = \'" + username + "\'"+" and"+" password = \'" + password + "\'").uniqueResult();
        if(user != null) {
            HibernateUtil.closeSession();
            return true;
        } else {
            return false;
        }
    }
	
	public User getUserRoles(String username) {
		Session ses = HibernateUtil.getSession();
		
		User user = (User) ses.createQuery("FROM User WHERE username = \'" + username + "\'").uniqueResult();
		
		return user;
	}

	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		
		User user = (User) ses.createQuery("FROM User WHERE user_id = \'" + id + "\'").uniqueResult();
		
		return user;
	}

}
