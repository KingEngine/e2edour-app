package com.e2edour.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2edour.app.dao.bean.LeaveMsg;
import com.e2edour.app.dao.impl.LeaveMsgDaoImpl;
import com.e2edour.app.facade.ILeaveMsgService;
import com.e2edour.app.facade.bean.LeaveMsgBO;

@Service("LeaveMsgService")
public class LeaveMsgServiceImpl implements ILeaveMsgService{

	@Autowired
	private LeaveMsgDaoImpl leaveDao;
	
	public void insert(LeaveMsgBO leaveMsgBO) {
		LeaveMsg dao = new LeaveMsg();
		BeanUtils.copyProperties(leaveMsgBO, dao);
		leaveDao.insert(dao);
	}

}
