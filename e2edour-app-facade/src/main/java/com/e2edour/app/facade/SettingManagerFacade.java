package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.NavigationBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.app.facade.response.Menus;
import com.e2edour.common.bean.Page;

/**
 * 配置管理facade
 */
public interface SettingManagerFacade {

    public Page<NavigationBO> queryNavigationForPage(Page page,NavigationBO navigationBO);

    public CommonResponse addNaviagtion(NavigationBO navigationBO);

    public CommonResponse deleteNaviagtion(NavigationBO navigationBO);

    public CommonResponse updateNaviagtion(NavigationBO navigationBO);

    public CommonResponse queryNavigationForOne(NavigationBO navigationBO);

    public Page<Menus> queryMenusForPage(Page page,Menus menus);

    public CommonResponse addMenu(Menus menu);

    public CommonResponse deleteMenu(Menus menu);

    public CommonResponse queryMenuForOne(Menus menu);

    public CommonResponse updateMenu(Menus menu);
}
