package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.CustomerBO;

/**
 * vip会员操作facade
 */
public interface CustomerFacade {

    void registerVIP(CustomerBO bo) throws Exception;

    void login(CustomerBO bo) throws Exception;
}
