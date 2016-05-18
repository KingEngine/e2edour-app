package com.e2edour.app.facade.bean;

import java.io.Serializable;
import java.util.Date;


public class LeaveMsgBO implements Serializable{
	
	private static final long serialVersionUID = 5732212734350861170L;

	private String id;// 主键

	private Date leaveDate;// 留言时间

	private String msg;// 留言内容

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
