package com.e2edour.app.service;

import java.util.ArrayList;
import java.util.List;

import com.e2edour.app.facade.FetcherFacade;;
import com.e2edour.app.facade.bean.RspCode;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.Page;
import com.e2edour.common.utils.LoggerUtil;
import com.e2edour.common.utils.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.e2edour.common.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2edour.app.dao.bean.FetcherIndex;
import com.e2edour.app.dao.impl.FetcherIndexDaoImpl;
import com.e2edour.app.facade.bean.FetcherIndexBO;


@Service("fetcherService")
public class FetcherServiceImpl implements FetcherFacade {

    @Autowired
    private FetcherIndexDaoImpl fetcherIndexDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<FetcherIndexBO> getFetcherIndexs() {
        List<FetcherIndex> indexs = fetcherIndexDao.selectList(new FetcherIndex());
        List<FetcherIndexBO> indexBos = new ArrayList<FetcherIndexBO>();
        for (FetcherIndex o : indexs) {
            indexBos.add(BeanUtil.copyOne2One(o, FetcherIndexBO.class));
        }
        return indexBos;
    }

    @Override
    public Page<FetcherIndexBO> queryFetcherIndexsForPage(Page<?> page) {
        FetcherIndex fetcherIndex = new FetcherIndex();
        Page<FetcherIndex> daoPage = fetcherIndexDao.selectPagination(page, fetcherIndex);
        Page<FetcherIndexBO> resultPage = new Page<FetcherIndexBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        List<FetcherIndexBO> list = BeanUtil.copyList2List(daoPage.getRows(), FetcherIndexBO.class);
        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public boolean addFetcherIndex(FetcherIndexBO fetcherIndexBO) {
        FetcherIndex fetcherIndex = BeanUtil.copyOne2One(fetcherIndexBO, FetcherIndex.class);
        try {
            fetcherIndexDao.insert(fetcherIndex);
        } catch (Exception e) {
            logger.error("FetcherService addFetcherIndex error{}", LoggerUtil.getErrorMsg(e));
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFetcherIndex(FetcherIndexBO fetcherIndexBO) {
        FetcherIndex fetcherIndex = BeanUtil.copyOne2One(fetcherIndexBO, FetcherIndex.class);
        try {
            fetcherIndexDao.remove(fetcherIndex);
        } catch (Exception e) {
            logger.error("FetcherService deleteFetcherIndex error{}", LoggerUtil.getErrorMsg(e));
            return false;
        }
        return true;
    }

    @Override
    public boolean updateFetcherIndex(FetcherIndexBO fetcherIndexBO) {
        FetcherIndex fetcherIndex = BeanUtil.copyOne2One(fetcherIndexBO, FetcherIndex.class);
        try {
            fetcherIndexDao.updateByPk(fetcherIndex,fetcherIndex.getId());
        } catch (Exception e) {
            logger.error("FetcherService updateFetcherIndex error{}", LoggerUtil.getErrorMsg(e));
            return false;
        }
        return true;
    }
}
