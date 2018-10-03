package com.sm.dao.impl;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.dao.ACDao;
import com.sm.entity.AC;

@Repository
public class ACDaoImpl implements ACDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void createAC(AC ac) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ac);
	}
	
	public void updateAC(AC ac) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ac);
	}

	public List<AC> getACList(String roomName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM AC WHERE idRoom = (SELECT id FROM Rooms WHERE nameRoom = :name)");
		query.setParameter("name", roomName);
		List<AC> ac = query.getResultList();
		return ac;
	}

	@Override
	public AC getAC(AC ac) {
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("FROM AC WHERE ip = :ip");
//		query.setParameter("ip", ipAC);
		return session.get(AC.class, ac.getIp());

	}

	@Override
	public void saveOrUpdate(AC ac) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ac);
	}
	
	
}
