package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;


public class ReimbursementService {

	//instantiate an AvengerDAO to use its method
	ReimbursementDao rDao = new ReimbursementDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<Reimbursement> getAllReimbursements() {
		return rDao.getAllReimbursements();
	}
	
	//all we're doing is calling the dao method in order to get a List of all the Avengers to send to the controller

}
