package com.e2edour.app.service;


import com.e2edour.app.dao.bean.*;
import com.e2edour.app.dao.impl.CheckedEaasyDaoImpl;
import com.e2edour.app.dao.impl.DeletedEaasyDaoImpl;
import com.e2edour.app.dao.impl.UncheckedEaasyDaoImpl;
import com.e2edour.app.facade.EaasyManagerFacade;
import com.e2edour.app.facade.bean.CheckedEaasyBO;
import com.e2edour.app.facade.bean.RspCode;
import com.e2edour.app.facade.bean.UncheckedEaasyBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.Constants;
import com.e2edour.common.bean.Page;
import com.e2edour.common.utils.BeanUtil;
import com.e2edour.common.utils.LoggerUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by King on 2015/11/26.
 */

@Service("eaasyManagerService")
public class EaasyManagerServiceImpl implements EaasyManagerFacade{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UncheckedEaasyDaoImpl uncheckedEaasyDao;

    @Autowired
    private CheckedEaasyDaoImpl checkedEaasyDao;
    @Autowired
    private DeletedEaasyDaoImpl deletedEaasyDao;

    @Override
    public CommonResponse addUncheckedEaasy(UncheckedEaasyBO uncheckedEaasyBO) {
        CommonResponse response = new CommonResponse();
        try {
            uncheckedEaasyDao.insert(BeanUtil.copyOne2One(uncheckedEaasyBO, UncheckedEaasyDO.class));
            response.setResCode(RspCode.success.getCode());
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    /**
     * 查询未审核文章
     * @param page
     * @param checkedEaasyBO
     * @return
     */
    @Override
    public Page<CheckedEaasyBO> queryCheckedEaasyForPage(Page page, CheckedEaasyBO checkedEaasyBO) {
        CheckedEaasyDO checkedEaasyDO = BeanUtil.copyOne2One(checkedEaasyBO, CheckedEaasyDO.class);
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        //根据时间倒序查询
        Page<CheckedEaasyDO> daoPage = checkedEaasyDao.selectPagination(page, checkedEaasyDO, sort);
        Page<CheckedEaasyBO> resultPage = new Page<CheckedEaasyBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        resultPage.setRows(BeanUtil.copyList2List(daoPage.getRows(), CheckedEaasyBO.class));
        return resultPage;
    }

    @Override
    public Page<UncheckedEaasyBO> queryUnCheckedEaasyForPage(Page page, UncheckedEaasyBO uncheckedEaasyBO) {
        UncheckedEaasyDO uncheckedEaasyDO = BeanUtil.copyOne2One(uncheckedEaasyBO, UncheckedEaasyDO.class);
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        //根据时间倒序查询
        Page<UncheckedEaasyDO> daoPage = uncheckedEaasyDao.selectPagination(page, uncheckedEaasyDO, sort);
        Page<UncheckedEaasyBO> resultPage = new Page<UncheckedEaasyBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        resultPage.setRows(BeanUtil.copyList2List(daoPage.getRows(), UncheckedEaasyBO.class));
        return resultPage;
    }

    @Override
    public CommonResponse queryUncheckedEaasyForOne(UncheckedEaasyBO uncheckedEaasyBO) {
        CommonResponse response = new CommonResponse();
        try {
            UncheckedEaasyDO result = uncheckedEaasyDao.selectOne(BeanUtil.copyOne2One(uncheckedEaasyBO, UncheckedEaasyDO.class));
            response.setResCode(RspCode.success.getCode());
            response.setObj(BeanUtil.copyOne2One(result, UncheckedEaasyBO.class));
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public CommonResponse verifyUncheckedEaasy(String[] ids, String status) {
        List<UncheckedEaasyDO> uncheckeds= new ArrayList<UncheckedEaasyDO>();
        CommonResponse response = new CommonResponse();
        response.setResCode(RspCode.success.getCode());
        try {
            for (String id : ids) {
                UncheckedEaasyDO uncheckedEaasyDO = new UncheckedEaasyDO();
                uncheckedEaasyDO.setId(id);
                //查询未审核的贴子,同时把贴子从未审核库中删除
                uncheckeds.add(uncheckedEaasyDao.selectOne(uncheckedEaasyDO));
                uncheckedEaasyDao.remove(uncheckedEaasyDO);
            }
            //如果文章通过,则把数据放到审核库中
            if (StringUtils.equals(status, Constants.pass)) {
                for (UncheckedEaasyDO unchecked : uncheckeds) {
                    CheckedEaasyDO checkedEaasyDO = BeanUtil.copyOne2One(unchecked, CheckedEaasyDO.class);
                    checkedEaasyDO.setCreateData(new Date());
                    checkedEaasyDao.insert(checkedEaasyDO);
                }
            }
            //如果文章不通过,则把数据放到删除库中
            if (StringUtils.equals(status, Constants.reject)) {
                for (UncheckedEaasyDO unchecked : uncheckeds) {
                    DeletedEaasyDO deletedEaasyDO = BeanUtil.copyOne2One(unchecked, DeletedEaasyDO.class);
                    deletedEaasyDO.setCreateData(new Date());
                    deletedEaasyDao.insert(deletedEaasyDO);
                }
            }
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }
}
