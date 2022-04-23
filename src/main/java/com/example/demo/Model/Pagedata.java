package com.example.demo.Model;

public class Pagedata {
	
	private String id;
	private String firstname;
	private String email;
	private Long phoneno;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Pagedata(String id, String firstname, String email, Long phoneno, String status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.phoneno = phoneno;
		this.status = status;
	}
	
	
	

}
