package com.e2edour.app.facade.bean;

import java.io.Serializable;


public class SurpriseBO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String title;//标题
	
	private String desc;//形容
	
	private String logoPath;//logo图片地址
	
	private String url;//url跳转地址

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
