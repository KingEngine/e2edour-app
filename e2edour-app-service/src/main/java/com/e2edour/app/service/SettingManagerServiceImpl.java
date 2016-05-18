package com.e2edour.app.service;

import com.e2edour.app.dao.bean.MenusDO;
import com.e2edour.app.dao.bean.NavigationDO;
import com.e2edour.app.dao.impl.MenusDaoImpl;
import com.e2edour.app.dao.impl.NavigationDaoImpl;
import com.e2edour.app.facade.SettingManagerFacade;
import com.e2edour.app.facade.bean.NavigationBO;
import com.e2edour.app.facade.bean.RspCode;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.app.facade.response.Menus;
import com.e2edour.common.bean.Page;
import com.e2edour.common.utils.BeanUtil;
import com.e2edour.common.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by King on 2015/11/21.
 */
@Service("SettingManagerService")
public class SettingManagerServiceImpl implements SettingManagerFacade {
    @Autowired
    private NavigationDaoImpl navigationDao;

    @Autowired
    private MenusDaoImpl menusDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Page<NavigationBO> queryNavigationForPage(Page page, NavigationBO navigationBO) {
        Page<NavigationDO> daoPage = navigationDao.selectPagination(page, BeanUtil.copyOne2One(navigationBO, NavigationDO.class));
        Page<NavigationBO> resultPage = new Page<NavigationBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        resultPage.setRows(BeanUtil.copyList2List(daoPage.getRows(), NavigationBO.class));
        return resultPage;
    }

    @Override
    public CommonResponse addNaviagtion(NavigationBO navigationBO) {
        CommonResponse response = new CommonResponse();
        try {
            navigationDao.insert(BeanUtil.copyOne2One(navigationBO, NavigationDO.class));
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse deleteNaviagtion(NavigationBO navigationBO) {
        CommonResponse response = new CommonResponse();
        try {
            navigationDao.remove(BeanUtil.copyOne2One(navigationBO, NavigationDO.class));
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse updateNaviagtion(NavigationBO navigationBO) {
        CommonResponse response = new CommonResponse();
        try {
            navigationDao.updateByPk(BeanUtil.copyOne2One(navigationBO, NavigationDO.class),navigationBO.getId());
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse queryNavigationForOne(NavigationBO navigationBO) {
        CommonResponse response = new CommonResponse();
        try {
            NavigationDO result = navigationDao.selectOne(BeanUtil.copyOne2One(navigationBO, NavigationDO.class));
            response.setResCode(RspCode.success.getCode());
            response.setObj(BeanUtil.copyOne2One(result, NavigationBO.class));
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public Page<Menus> queryMenusForPage(Page page, Menus menus) {
        Sort sort = new Sort(Sort.Direction.ASC, "menuId");
        Page<MenusDO> daoPage = menusDao.selectPagination(page, BeanUtil.copyOne2One(menus, MenusDO.class),sort);
        Page<Menus> resultPage = new Page<Menus>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        resultPage.setRows(BeanUtil.copyList2List(daoPage.getRows(), Menus.class));
        return resultPage;
    }

    @Override
    public CommonResponse addMenu(Menus menu) {
        CommonResponse response = new CommonResponse();
        try {
            menusDao.insert(BeanUtil.copyOne2One(menu, MenusDO.class));
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse deleteMenu(Menus menu) {
        CommonResponse response = new CommonResponse();
        try {
            menusDao.remove(BeanUtil.copyOne2One(menu, MenusDO.class));
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse queryMenuForOne(Menus menu) {
        CommonResponse response = new CommonResponse();
        try {
            MenusDO result = menusDao.selectOne(BeanUtil.copyOne2One(menu, MenusDO.class));
            response.setResCode(RspCode.success.getCode());
            response.setObj(BeanUtil.copyOne2One(result, Menus.class));
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse updateMenu(Menus menu) {
        CommonResponse response = new CommonResponse();
        try {
            menusDao.updateByPk(BeanUtil.copyOne2One(menu, MenusDO.class),menu.getId());
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }
}
