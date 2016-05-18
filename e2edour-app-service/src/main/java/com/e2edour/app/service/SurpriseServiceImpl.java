package com.e2edour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2edour.app.dao.bean.Surprise;
import com.e2edour.app.dao.impl.SurpriseDaoImpl;
import com.e2edour.app.facade.ISurpriseService;
import com.e2edour.app.facade.bean.SurpriseBO;
import com.e2edour.common.utils.BeanUtil;

@Service("SurpriseService")
public class SurpriseServiceImpl implements ISurpriseService{

	@Autowired
	private SurpriseDaoImpl surpriseDao;
	public List<SurpriseBO> getSurprises() {
		List<Surprise> dos = surpriseDao.selectList(new Surprise());
		List<SurpriseBO> bos= BeanUtil.copyList2List(dos, SurpriseBO.class);
		return bos;
	}
}
