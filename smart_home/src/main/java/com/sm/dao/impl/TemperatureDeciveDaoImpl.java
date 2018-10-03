package com.sm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.dao.TemperatureDeciveDao;
import com.sm.entity.TemperatureDecive;

@Repository
public class TemperatureDeciveDaoImpl implements TemperatureDeciveDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(TemperatureDecive temperatureDecive) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(temperatureDecive);
	}

}
