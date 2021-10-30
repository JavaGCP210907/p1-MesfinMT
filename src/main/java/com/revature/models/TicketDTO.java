package com.revature.models;

public class TicketDTO {
	private float amount;
	private String description;
	private String type;
	private int userid;
	private String status;
	private int ticket_id;
	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDTO(float amount, String description, String type, int userid) {
		super();
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.userid = userid;
	}

	
	public TicketDTO(float amount, String description, String type, int userid, String status, int ticket_id) {
		super();
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.userid = userid;
		this.status = status;
		this.ticket_id = ticket_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
}
