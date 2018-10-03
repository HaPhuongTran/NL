package com.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "humidity_decive")
public class HumidityDecive {

	@Id
	@Column(name = "ip", nullable = false, unique = true)
	private String ip;
	
	@Column(name = "name_hd", nullable = false, unique = true)
	private String nameHD;
	
	@Column(name = "state")
	private String state = "off";
	
	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Rooms roomId;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNameHD() {
		return nameHD;
	}

	public void setNameHD(String nameHD) {
		this.nameHD = nameHD;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRoomId() {
		return roomId.getId();
	}

	public void setRoomId(Rooms roomId) {
		this.roomId = roomId;
	}

}
