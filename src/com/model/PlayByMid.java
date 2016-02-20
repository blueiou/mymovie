package com.model;

import java.io.Serializable;

public class PlayByMid implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1453185555076008952L;

	private String sysname;
	
	private String playtime;
	
	private double price;

	private String roomname;
	private String version;
	private String language;
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getPlaytime() {
		return playtime;
	}

	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
//显示特定的电影的放映时刻表
	public PlayByMid(String sysname, String playtime, double price) {
		super();
		this.sysname = sysname;
		this.playtime = playtime;
		this.price = price;
	}

	public PlayByMid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayByMid(String sysname, String playtime, double price,
			String roomname, String version) {
		super();
		this.sysname = sysname;
		this.playtime = playtime;
		this.price = price;
		this.roomname = roomname;
		this.version = version;
	}

	public PlayByMid(String sysname, String playtime, double price,
			String roomname, String version, String language) {
		super();
		this.sysname = sysname;
		this.playtime = playtime;
		this.price = price;
		this.roomname = roomname;
		this.version = version;
		this.language = language;
	}
	
	
	
	
	
}
