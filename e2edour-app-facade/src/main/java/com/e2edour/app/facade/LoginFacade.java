package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.OperatorBO;
import com.e2edour.app.facade.response.MenusRes;

public interface LoginFacade {

	
	public MenusRes getFirstMenu();
	
	public MenusRes getChildMens(String firstMenuId);
	
	/**
	 * 登陆操作
	 * @param Bo
	 * @return
	 */
	public OperatorBO login(OperatorBO bo);
}
