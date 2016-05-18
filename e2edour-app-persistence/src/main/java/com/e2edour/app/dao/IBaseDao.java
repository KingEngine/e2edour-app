package com.e2edour.app.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import com.e2edour.common.bean.Page;

public interface IBaseDao<T> {

	List<T> selectList(T t);
	
	T selectOne(T t);

	void insert(T t);

	Page<T> selectPagination(Page page,T t,Sort sort);

	Page<T> selectPagination(Page page,T t);

	void remove(T t);

	public void updateByPk(T t,String id);
}
