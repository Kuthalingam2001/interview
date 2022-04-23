package com.example.demo.Response;



public class CandidateRespon {
	private boolean Sucess;
	private String msg;
   
	public boolean isSucess() {
		return Sucess;
	}
	public void setSucess(boolean sucess) {
		Sucess = sucess;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public CandidateRespon(boolean sucess, String msg) {
		super();
		Sucess = sucess;
		this.msg = msg;
	}
	

}
