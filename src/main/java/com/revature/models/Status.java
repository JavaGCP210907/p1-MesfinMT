package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Status_id")
	private int id;
	
	//going to leave the rest of the fiels unannotated for Hibernate to handle itself
	@Column(name = "Status")
	private String Status;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int id, String status) {
		super();
		this.id = id;
		Status = status;
	}

	public Status(String status) {
		super();
		Status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", Status=" + Status + "]";
	}
	
	
}
