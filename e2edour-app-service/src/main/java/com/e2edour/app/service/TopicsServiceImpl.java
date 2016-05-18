package com.e2edour.app.service;

import com.e2edour.app.dao.bean.CheckedTopicsDO;
import com.e2edour.app.dao.bean.DeletedTopicsDO;
import com.e2edour.app.dao.bean.UncheckedTopicsDO;
import com.e2edour.app.dao.impl.CheckedTopicsDaoImpl;
import com.e2edour.app.dao.impl.DeletedTopicsDaoImpl;
import com.e2edour.app.dao.impl.UncheckedTopicsDaoImpl;
import com.e2edour.app.facade.TopicsFacade;
import com.e2edour.app.facade.bean.CheckedTopicsBO;
import com.e2edour.app.facade.bean.RspCode;
import com.e2edour.app.facade.bean.UncheckedTopicsBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.*;
import com.e2edour.common.utils.BeanUtil;
import com.e2edour.common.utils.LoggerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("TopicsService")
public class TopicsServiceImpl implements TopicsFacade {

    @Autowired
    private UncheckedTopicsDaoImpl uncheckedTopicsDao;

    @Autowired
    private CheckedTopicsDaoImpl checkedTopicsDao;
    @Autowired
    private DeletedTopicsDaoImpl deletedTopicsDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void addUncheckedTopic(UncheckedTopicsBO uncheckedTopicsBO) {
        UncheckedTopicsDO uncheckedTopicsDO = BeanUtil.copyOne2One(uncheckedTopicsBO, UncheckedTopicsDO.class);
        uncheckedTopicsDao.insert(uncheckedTopicsDO);
    }

    @Override
    public Page<UncheckedTopicsBO> queryUncheckedTopicsForPage(Page<?> page, UncheckedTopicsBO uncheckedTopicsBO) {
        Page<UncheckedTopicsDO> daoPage = uncheckedTopicsDao.selectPagination(page, BeanUtil.copyOne2One(uncheckedTopicsBO, UncheckedTopicsDO.class));
        Page<UncheckedTopicsBO> resultPage = new Page<UncheckedTopicsBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        List<UncheckedTopicsBO> list = new ArrayList<UncheckedTopicsBO>();
        for (UncheckedTopicsDO uncheckedTopicsDO : daoPage.getRows()) {
            UncheckedTopicsBO bo = BeanUtil.copyOne2One(uncheckedTopicsDO, UncheckedTopicsBO.class);
            bo.setCreateDateStr(DateFormatUtils.format(bo.getCreateDate(), Constants.DATE_PATTERN));
            for (TopicsType value : TopicsType.values()) {
                if (StringUtils.equals(bo.getType(), value.getCode())) {
                    bo.setType(value.getDesc());
                    break;
                }
            }
            for (TopicsChannel value : TopicsChannel.values()) {
                if (StringUtils.equals(bo.getChannel(), value.getCode())) {
                    bo.setChannel(value.getDesc());
                    break;
                }
            }
            list.add(bo);
        }

        resultPage.setRows(list);
        return resultPage;
    }

    @Override
    public CommonResponse verifyUncheckedTopics(String[] ids, String status) {
        List<UncheckedTopicsDO> uncheckedTopicsDOs = new ArrayList<UncheckedTopicsDO>();
        CommonResponse response = new CommonResponse();
        response.setResCode(RspCode.success.getCode());
        try {
            for (String id : ids) {
                UncheckedTopicsDO uncheckedTopicsDO = new UncheckedTopicsDO();
                uncheckedTopicsDO.setId(id);
                //查询未审核的贴子,同时把贴子从未审核库中删除
                uncheckedTopicsDOs.add(uncheckedTopicsDao.selectOne(uncheckedTopicsDO));
                uncheckedTopicsDao.remove(uncheckedTopicsDO);
            }
            //如果贴子通过,则把数据放到审核库中
            if (StringUtils.equals(status, Constants.pass)) {
                for (UncheckedTopicsDO uncheckedTopicsDO : uncheckedTopicsDOs) {
                    CheckedTopicsDO checkedTopicsDO = BeanUtil.copyOne2One(uncheckedTopicsDO, CheckedTopicsDO.class);
                    checkedTopicsDO.setCreateDate(new Date());
                    checkedTopicsDao.insert(checkedTopicsDO);
                }
            }
            //如果贴子通过,则把数据放到删除库中
            if (StringUtils.equals(status, Constants.reject)) {
                for (UncheckedTopicsDO uncheckedTopicsDO : uncheckedTopicsDOs) {
                    DeletedTopicsDO deletedTopicsDO = BeanUtil.copyOne2One(uncheckedTopicsDO, DeletedTopicsDO.class);
                    deletedTopicsDO.setCreateDate(new Date());
                    deletedTopicsDao.insert(deletedTopicsDO);
                }
            }
        } catch (Exception e) {
            logger.error(LoggerUtil.getErrorMsg(e));
            response.setResCode(RspCode.error.getCode());
            response.setResMsg(e.getMessage());
        }
        return response;
    }

    @Override
    public List<UncheckedTopicsBO> getUncheckedTopics(UncheckedTopicsBO uncheckedTopicsBO) {
        UncheckedTopicsDO uncheckedTopicsDO = BeanUtil.copyOne2One(uncheckedTopicsBO, UncheckedTopicsDO.class);
        List<UncheckedTopicsDO> topics = uncheckedTopicsDao.selectList(uncheckedTopicsDO);
        return BeanUtil.copyList2List(topics, UncheckedTopicsBO.class);
    }

    @Override
    public Page<CheckedTopicsBO> queryCheckedTopicsForPage(Page<?> page, CheckedTopicsBO checkedTopicsBO) {
        CheckedTopicsDO checkedTopicsDO = BeanUtil.copyOne2One(checkedTopicsBO, CheckedTopicsDO.class);
        Sort sort = new Sort(Sort.Direction.DESC, "createDate");
        //根据时间倒序查询
        Page<CheckedTopicsDO> daoPage = checkedTopicsDao.selectPagination(page, checkedTopicsDO, sort);
        Page<CheckedTopicsBO> resultPage = new Page<CheckedTopicsBO>();
        resultPage.setCurrent(daoPage.getCurrent());
        resultPage.setRowCount(page.getRowCount());
        resultPage.setTotal(daoPage.getTotal());
        resultPage.setRows(BeanUtil.copyList2List(daoPage.getRows(), CheckedTopicsBO.class));
        return resultPage;
    }
}
