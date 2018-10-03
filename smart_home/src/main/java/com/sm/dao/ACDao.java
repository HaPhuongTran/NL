package com.sm.dao;

import java.util.List;

import com.sm.entity.AC;

public interface ACDao {
	public void createAC(AC ac);
	public void updateAC(AC ac);
	public List<AC> getACList(String roomName);
	public AC getAC(AC ac);
	public void saveOrUpdate(AC ac);
}
