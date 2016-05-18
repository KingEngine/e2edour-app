package com.e2edour.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2edour.app.dao.bean.MenusDO;
import com.e2edour.app.dao.bean.OperatorDO;
import com.e2edour.app.dao.impl.MenusDaoImpl;
import com.e2edour.app.dao.impl.OperatorDaoImpl;
import com.e2edour.app.facade.LoginFacade;
import com.e2edour.app.facade.bean.OperatorBO;
import com.e2edour.app.facade.response.Menus;
import com.e2edour.app.facade.response.MenusRes;
import com.e2edour.common.security.SecurityFactory;
import com.e2edour.common.utils.BeanUtil;


@Service("loginService")
public class LoginServiceImpl  implements LoginFacade{

	@Autowired
	private MenusDaoImpl menusDao;
	
	@Autowired
	private OperatorDaoImpl operatorDao;
	
	@Override
	public MenusRes getFirstMenu() {
		MenusDO menu = new MenusDO();
		menu.setMenuLevel("1");
		List<MenusDO> menus = menusDao.selectList(menu);
		List<Menus> result = BeanUtil.copyList2List(menus, Menus.class);
		MenusRes res = new MenusRes();
		res.setMenus(result);
		return res;
	}
	@Override
	public MenusRes getChildMens(String firstMenuId) {
		MenusDO menu = new MenusDO();
		menu.setMenuLevel("2");
		menu.setParentMenuId(firstMenuId);
		List<MenusDO> secondMenus = menusDao.selectList(menu);
		List<Map<Object,Object>> result = new ArrayList<Map<Object,Object>>();
		for(MenusDO o:secondMenus){
			Map<Object, Object> second = new HashMap<Object, Object>();
			second.put("secondName", o.getName());
			second.put("secondId", o.getId());
			//查询三级菜单
			MenusDO thirdDO = new MenusDO();
			thirdDO.setMenuLevel("3");
			thirdDO.setParentMenuId(o.getMenuId());
			List<MenusDO> thirdMenuDOs =  menusDao.selectList(thirdDO);
			List<Menus> thirdMenus = BeanUtil.copyList2List(thirdMenuDOs, Menus.class);
			second.put("thirdMenus", thirdMenus);
			result.add(second);
		}
		MenusRes res = new MenusRes();
		res.setChildMenus(result);
		return res;
	}
	
	@Override
	public OperatorBO login(OperatorBO bo) {
		bo.setPwd(SecurityFactory.signMD5(bo.getPwd()));
		OperatorDO operatorDO = BeanUtil.copyOne2One(bo, OperatorDO.class);
		OperatorDO result = operatorDao.selectOne(operatorDO);
		bo = null;
		if(null!=result){
			bo= BeanUtil.copyOne2One(result, OperatorBO.class);
		}
		return bo;
	}
}
