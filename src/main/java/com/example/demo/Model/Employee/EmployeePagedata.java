package com.example.demo.Model.Employee;

public class EmployeePagedata {
	
	private String username;
	private String firstname;
	private String email;
	private String roll;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public EmployeePagedata(String username, String firstname, String email, String roll) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.email = email;
		this.roll = roll;
	}
	

}
