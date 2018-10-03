package com.sm.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sm.dao.ACDao;
import com.sm.entity.AC;
import com.sm.service.ACService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ACServiceImpl implements ACService{
	
	@Autowired
	ACDao acDao;
	
	@Transactional
	public void createAC(AC ac) {
		acDao.createAC(ac);
	}
	
	@Transactional
	public void updateAC(AC ac) {
		acDao.updateAC(ac);
	}

	@Override
	@Transactional
	public void saveOrUpdate(AC ac) {
		acDao.saveOrUpdate(ac);
	}

	@Override
	public List<AC> getListAC(String roomName) {
		return acDao.getACList(roomName);
	}

	@Override
	public AC getAC(AC ac) {
		return acDao.getAC(ac);
	}
}
