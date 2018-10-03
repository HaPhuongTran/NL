package com.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="temperature_decive")
public class TemperatureDecive {
	
	@Id
	@Column(name = "ip", nullable = false, unique = true)
	private String ip;
	
	@Column(name = "state", nullable = false)
	private String state = "off";
	
	@Column(name = "name_td", nullable = false, unique = true)
	private String nameTD;
	
	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Rooms roomId;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNameTd() {
		return nameTD;
	}

	public void setNameTd(String nameTd) {
		this.nameTD = nameTd;
	}

	public int getRoomId() {
		return roomId.getId();
	}

	public void setRoomId(Rooms roomId) {
		this.roomId = roomId;
	}
	
	
}
