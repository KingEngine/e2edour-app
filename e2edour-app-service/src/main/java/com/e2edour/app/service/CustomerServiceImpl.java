package com.e2edour.app.service;

import com.e2edour.app.dao.bean.CustomerDO;
import com.e2edour.app.dao.impl.CustomerDaoImpl;
import com.e2edour.app.facade.CustomerFacade;
import com.e2edour.app.facade.bean.CustomerBO;
import com.e2edour.common.utils.BeanUtil;
import com.e2edour.common.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by King on 2015/9/30.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerFacade {

    @Autowired
    private CustomerDaoImpl customerDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void registerVIP(CustomerBO bo) throws Exception {
        try {
            CustomerDO customerDO = BeanUtil.copyOne2One(bo, CustomerDO.class);
            customerDao.insert(customerDO);
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            throw e;
        }
    }

    @Override
    public void login(CustomerBO bo) throws Exception {
        CustomerDO customerDO = BeanUtil.copyOne2One(bo, CustomerDO.class);
        CustomerDO result = customerDao.selectOne(customerDO);
        if(null == result){
            throw new Exception();
        }
    }
}
