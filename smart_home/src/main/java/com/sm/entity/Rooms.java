package com.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_home", nullable = false)
	private HomeProject homeId;
	
	@Column(name = "name_room", nullable = false)
	private String nameRoom;
	
	public Rooms() {}
	
	public Rooms(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HomeProject getHomeId() {
		return homeId;
	}

	public void setHomeId(HomeProject homeId) {
		this.homeId = homeId;
	}

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	
}

