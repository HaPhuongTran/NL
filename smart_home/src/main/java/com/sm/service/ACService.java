package com.sm.service;

import java.util.List;

import com.sm.entity.AC;

public interface ACService {
	public void createAC(AC ac);
	public void updateAC(AC ac);
	public void saveOrUpdate(AC ac);
	public AC getAC(AC ac);
	public List<AC> getListAC(String roomName);
}
