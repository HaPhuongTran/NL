package com.sm.dao;

import com.sm.entity.HomeProject;

public interface HomeDao {
	public void addHome(HomeProject homeProject);
	public HomeProject getHome(String nameHome);
}
