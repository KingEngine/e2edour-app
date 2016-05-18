package com.e2edour.app.facade.bean;

import java.io.Serializable;

public class OperatorBO implements Serializable{

	private static final long serialVersionUID = 3920030267705808803L;

	private String name;
	
	private String pwd;
	
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
