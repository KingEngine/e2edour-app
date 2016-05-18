package com.e2edour.app.facade.bean;

import java.io.Serializable;

public class FetcherIndexBO implements Serializable {

	
	private static final long serialVersionUID = 679826952983214536L;

	private String id;

	private String className;

	private String[] urls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String[] getUrls() {
		return urls;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

}
