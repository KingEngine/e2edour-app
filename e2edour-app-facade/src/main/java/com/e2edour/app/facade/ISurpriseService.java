package com.e2edour.app.facade;

import java.util.List;

import com.e2edour.app.facade.bean.SurpriseBO;

public interface ISurpriseService {

	//读取抓取地址
	List<SurpriseBO> getSurprises();
}
