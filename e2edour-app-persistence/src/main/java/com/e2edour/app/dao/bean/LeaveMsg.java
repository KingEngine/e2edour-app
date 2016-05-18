package com.e2edour.app.dao.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 留言内容 
 * @author King
 */
@Document(collection="leave_msg")
public class LeaveMsg {

	@Id
	private String id;//主键
	
	private Date leaveDate;//留言时间
	
	private String msg;//留言内容

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
