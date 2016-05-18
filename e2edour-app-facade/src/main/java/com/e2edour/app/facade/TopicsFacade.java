package com.e2edour.app.facade;

/**
 * Created by King on 2015/11/19.
 */

import com.e2edour.app.facade.bean.CheckedTopicsBO;
import com.e2edour.app.facade.bean.TopicsBO;
import com.e2edour.app.facade.bean.UncheckedTopicsBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.Page;
import com.e2edour.common.bean.Response;

import java.util.List;

/**
 * 贴子管理facade
 */
public interface TopicsFacade {

    /**
     * 插入未审核贴子
     * @param uncheckedTopicsBO
     */
    public void addUncheckedTopic(UncheckedTopicsBO uncheckedTopicsBO);

    public Page<UncheckedTopicsBO> queryUncheckedTopicsForPage(Page<?> page,UncheckedTopicsBO uncheckedTopicsBO);

    /**
     * 审核未审核贴
     * @param ids
     * @param status
     * @return
     */
    public CommonResponse verifyUncheckedTopics(String[] ids,String status);

    public List<UncheckedTopicsBO> getUncheckedTopics(UncheckedTopicsBO uncheckedTopicsBO);

    public Page<CheckedTopicsBO> queryCheckedTopicsForPage(Page<?> page,CheckedTopicsBO checkedTopicsBO);
}
