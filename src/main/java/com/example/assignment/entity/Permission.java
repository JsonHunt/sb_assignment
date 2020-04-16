package com.example.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Had to fix permissions table, all customer ids had an extra 0

@Entity
@Table(name="permissions")
public class Permission {
	
	@Id
	private String token;
	private long emp_no;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(long emp_no) {
		this.emp_no = emp_no;
	}
}
