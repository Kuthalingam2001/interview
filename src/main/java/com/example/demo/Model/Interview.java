package com.example.demo.Model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="interview_details1")
public class Interview {
	
	private String candidateid;
	private String indate;
	private String time;
	private String candidatename;
	private String interviewername;
	private String interviewerusername;
	private String interviewerroll;
	
	
	
	public String getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}
	public String getCandidatename() {
		return candidatename;
	}
	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInterviewername() {
		return interviewername;
	}
	public void setInterviewername(String interviewername) {
		this.interviewername = interviewername;
	}
	
	public String getInterviewerusername() {
		return interviewerusername;
	}
	public void setInterviewerusername(String interviewerusername) {
		this.interviewerusername = interviewerusername;
	}
	public String getInterviewerroll() {
		return interviewerroll;
	}
	public void setInterviewerroll(String interviewerroll) {
		this.interviewerroll = interviewerroll;
	}
	
	

}
