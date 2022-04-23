package com.example.demo.Response;




public class Data {
	
	private String id;
	private String username;
	private String email;
	private String roll;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Data(String id, String username, String email, String roll) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.roll = roll;
	}
	
}
