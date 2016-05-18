package com.e2edour.app.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.e2edour.common.utils.LoggerUtil;
import com.e2edour.common.utils.XmlUtil;
import com.mongodb.WriteResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.e2edour.app.dao.IBaseDao;
import com.e2edour.common.bean.Page;
import org.springframework.data.mongodb.core.query.Update;

public class BaseDao<T> implements IBaseDao<T> {

    @Autowired
    private MongoTemplate template;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public MongoTemplate getTemplate() {
        return template;
    }

    @SuppressWarnings("unchecked")
    public List<T> selectList(T t) {

        Query query = getQuery(t);
        return (List<T>) template.find(query, t.getClass());
    }

    @Override
    public T selectOne(T t) {
        Query query = getQuery(t);
        return (T) template.findOne(query, t.getClass());
    }

    public void insert(T t) {
        template.insert(t);
    }

    private Query getQuery(Object object) {
        Query query = new Query();
        List<Criteria> criterias = getCriterias(object);
        for (Criteria c : criterias) {
            query.addCriteria(c);
        }
        return query;
    }

    private List<Criteria> getCriterias(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Field[] currentFields = clazz.getDeclaredFields();
        Field[] superFields = clazz.getSuperclass().getDeclaredFields();
        List<Field> fields = new ArrayList<Field>();
        fields.addAll(Arrays.asList(currentFields));
        fields.addAll(Arrays.asList(superFields));
        List<Criteria> criterias = new ArrayList<Criteria>();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (!StringUtils.equals("serialVersionUID", fieldName)) {
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter
                        + fieldName.substring(1);
                try {
                    Method getMethod = clazz.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(object, new Object[]{});
                    if (null != value) {
                        Criteria criteria = new Criteria(fieldName).is(value);
                        criterias.add(criteria);
                    }
                } catch (Exception e) {
                    logger.error(LoggerUtil.getErrorMsg(e));
                }
            }
        }
        return criterias;
    }

    /**
     * 带排序的分页查询
     * @param page
     * @param t
     * @param sort
     * @return
     */
    @Override
    public Page<T> selectPagination(Page page, T t,Sort sort) {
        Query query = getQuery(t);
        query.with(sort);
        return  selectPagination(page,query,t.getClass());
    }
    @Override
    public Page<T> selectPagination(Page page, T t) {
        Query query = getQuery(t);
        return  selectPagination(page,query,t.getClass());
    }
    private Page<T> selectPagination(Page page,Query query,Class clazz){
        long total = template.count(query,clazz);
        query.skip(page.getRowCount() * (page.getCurrent() - 1));
        query.limit(page.getRowCount());
        List<T> result = (List<T>) template.find(query, clazz);
        page.setRows(result);
        page.setTotal(total);
        return page;
    }

    @Override
    public void remove(T t) {
        template.remove(t);
    }

    public void updateByPk(T t,String id){
        template.updateMulti(new Query().addCriteria(Criteria.where("id").is(id)),getUpdate(t),t.getClass());
    }
    private Update getUpdate(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Field[] currentFields = clazz.getDeclaredFields();
        Field[] superFields = clazz.getSuperclass().getDeclaredFields();
        List<Field> fields = new ArrayList<Field>();
        fields.addAll(Arrays.asList(currentFields));
        fields.addAll(Arrays.asList(superFields));
        Update update = new Update();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (!StringUtils.equals("serialVersionUID", fieldName)) {
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + firstLetter
                        + fieldName.substring(1);
                try {
                    Method getMethod = clazz.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(object, new Object[]{});
                    if (null != value) {
                        update.set(fieldName,value);
                    }
                } catch (Exception e) {
                    logger.error(LoggerUtil.getErrorMsg(e));
                }
            }
        }
        return update;
    }
}
