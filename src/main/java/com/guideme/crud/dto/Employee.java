package com.guideme.crud.dto;

public class Employee {
	private String firstname, lastname, email, phonenumber, post;
	private int employeeid;

	public Employee() {
		super();
	}

	public Employee(String firstname) {
		super();
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
