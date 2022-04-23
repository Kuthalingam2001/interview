package com.example.demo.Response;



public class Responese {
	
	private boolean sucess;
	private String msg;
	private Data data;
		public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Responese(boolean sucess, String msg, Data data) {
		super();
		this.sucess = sucess;
		this.msg = msg;
		this.data = data;
	}
	

	

}
