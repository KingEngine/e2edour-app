package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.NavigationBO;

import java.util.List;

/**
 * www.e2edour.com
 * 前端服务
 * Created by King on 2015/9/13.
 */
public interface WebPFacade {

    /**
     * 得到导航栏列表
     * @return
     */
    List<NavigationBO> getNavigations();

}
