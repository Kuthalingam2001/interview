package com.example.demo.Response;

import com.example.demo.Model.Experience;
import com.example.demo.Model.Qualification;

public class Interviewrespon {
	
	private String id;
	private String firstname;
	private String lastname;
	private String time;
	private Qualification[] qualification;
	private Experience[] experience;
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
	public Qualification[] getQualification() {
		return qualification;
	}
	public void setQualification(Qualification[] qualification) {
		this.qualification = qualification;
	}
	public Experience[] getExperience() {
		return experience;
	}
	public void setExperience(Experience[] experience) {
		this.experience = experience;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Interviewrespon(String id, String firstname, String lastname, String time, Qualification[] qualification,
			Experience[] experience) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.time = time;
		this.qualification = qualification;
		this.experience = experience;
	}
	

}
