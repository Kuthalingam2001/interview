package com.example.demo.Response;

public class Interviewerresponse {
	
	private String msg;
	private Interviewrespon inter;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Interviewrespon getInter() {
		return inter;
	}
	public void setInter(Interviewrespon inter) {
		this.inter = inter;
	}
	public Interviewerresponse(String msg, Interviewrespon inter) {
		super();
		this.msg = msg;
		this.inter = inter;
	}
	
	

}
