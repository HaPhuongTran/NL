package com.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sm.dao.HumidityDeviceDao;
import com.sm.entity.HumidityDecive;
import com.sm.service.HumidityDeciveService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HumidityDeciveServiceImpl implements HumidityDeciveService {
	
	@Autowired
	HumidityDeviceDao humidityDeciveDao;

	@Override
	@Transactional
	public void saveOrUpdate(HumidityDecive humidityDecive) {
		humidityDeciveDao.saveOrUpdate(humidityDecive);
	}
	
}
