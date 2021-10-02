package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDao implements ReimbursementInterface {


	@Override
	public List<Reimbursement> getAllReimbursements() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursement"; //write out out SQL query
			
			Statement s = conn.createStatement(); //create a Statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); //empty ArrayList of Avengers
			
			//populate the ArrayList
			while(rs.next()) { //while there are still objects in the resultset
				
				//make a new Avenger object for each row
				Reimbursement a = new Reimbursement (
					rs.getInt("reimb_id"),
					rs.getDouble("reimb_amount"),
					rs.getString("reimb_submitted"),
					rs.getString("reimb_resolved"),
					rs.getString("reimb_description"),
					rs.getString("reimb_receipt"),
					rs.getInt("reimb_author"),
					rs.getInt("reimb_resolver"),
					rs.getInt("reimb_status_id"),
					rs.getInt("reimb_type_id")
					);
				
				
				//now we can add each new Avenger into the ArrayList
				reimbursementList.add(a);
			}
			
			//outside our while loop, once all avengers have been added, return the avengerList
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Get all avengers failed :(");
			e.printStackTrace();
		}
		
		
		
		return null;
		}

	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
