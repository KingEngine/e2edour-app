package com.e2edour.app.service;

import com.e2edour.app.dao.bean.NavigationDO;
import com.e2edour.app.dao.impl.NavigationDaoImpl;
import com.e2edour.app.facade.WebPFacade;
import com.e2edour.app.facade.bean.NavigationBO;
import com.e2edour.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by King on 2015/9/13.
 */
@Service("webPService")
public class WebPServiceImpl implements WebPFacade {

    @Autowired
    private NavigationDaoImpl navigationDao;

    @Override
    public List<NavigationBO> getNavigations() {
        List<NavigationDO> list = navigationDao.selectList(new NavigationDO());
        return BeanUtil.copyList2List(list, NavigationBO.class);
    }
}
