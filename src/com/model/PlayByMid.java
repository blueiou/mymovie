package com.model;

public class PlayByMid {

	private String sysname;
	
	private String playtime;
	
	private double price;

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
	
	
	
	
	
}
