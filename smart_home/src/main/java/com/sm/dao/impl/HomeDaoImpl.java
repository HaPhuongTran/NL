package com.sm.dao.impl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sm.dao.HomeDao;
import com.sm.entity.HomeProject;

@Repository
public class HomeDaoImpl implements HomeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addHome(HomeProject homeProject) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(homeProject);
	}
	
	public HomeProject getHome(String nameHome) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM HomeProject WHERE nameHome =:name");
		query.setParameter("name", nameHome);
		HomeProject home = (HomeProject) query.getSingleResult();
		return home;
	}
}
