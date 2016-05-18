package com.e2edour.app.facade.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MenusRes implements Serializable {

	private static final long serialVersionUID = 7609743120193075195L;

	private String resCode;

	private String resDesc;

	private List<Menus> menus;

	private List<Map<Object, Object>> childMenus;

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResDesc() {
		return resDesc;
	}

	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	public List<Map<Object, Object>> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<Map<Object, Object>> childMenus) {
		this.childMenus = childMenus;
	}

}
