package com.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "home")
public class HomeProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int idHome;
	
	@Column(name = "name", nullable = false, unique=true)
	private String nameHome;
	
	public HomeProject(){}
	
	public HomeProject(int idHome) {
		this.idHome = idHome;
	}

	public int getId() {
		return idHome;
	}

	public void setId(int id) {
		this.idHome = id;
	}

	public String getNameHome() {
		return nameHome;
	}

	public void setNameHome(String nameHome) {
		this.nameHome = nameHome;
	}

	public int getIdHome() {
		return idHome;
	}

	public void setIdHome(int idHome) {
		this.idHome = idHome;
	}

}
