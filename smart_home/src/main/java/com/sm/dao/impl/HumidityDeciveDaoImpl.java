package com.sm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.dao.HumidityDeviceDao;
import com.sm.entity.HumidityDecive;

@Repository
public class HumidityDeciveDaoImpl implements HumidityDeviceDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(HumidityDecive humidityDecive) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(humidityDecive);
	}

}
