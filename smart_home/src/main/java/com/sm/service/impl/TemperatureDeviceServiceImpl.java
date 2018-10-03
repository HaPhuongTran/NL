package com.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sm.dao.TemperatureDeciveDao;
import com.sm.entity.TemperatureDecive;
import com.sm.service.TemperatureDeciveService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TemperatureDeviceServiceImpl implements TemperatureDeciveService {
	@Autowired
	TemperatureDeciveDao temperatureDeciveDao;

	@Override
	@Transactional
	public void saveOrUpdate(TemperatureDecive temperatureDecive) {
		temperatureDeciveDao.saveOrUpdate(temperatureDecive);
	}
	
}
