package com.example.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long dept_no;
	
	@Column(name="dept_name")
	private String name;

	

	public long getDept_no() {
		return dept_no;
	}

	public void setDept_no(long dept_no) {
		this.dept_no = dept_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
