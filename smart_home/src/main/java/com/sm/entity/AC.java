package com.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ac")
public class AC {
	@Id
	@Column(name = "ip", nullable = false, unique = true)
	private String ip;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name_ac;
	
	@Column(name = "state", nullable = false)
	private String state = "off";

	@ManyToOne
	@JoinColumn(name = "id_room", nullable = false)
	private Rooms idRoom;

	public int getIdRoom() {
		return idRoom.getId();
	}

	public void setIdRoom(Rooms idRoom) {
		this.idRoom = idRoom;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName_ac() {
		return name_ac;
	}

	public void setName_ac(String name_ac) {
		this.name_ac = name_ac;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
