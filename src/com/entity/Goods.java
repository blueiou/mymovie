package com.entity;

public  class Goods {

	private String sysname;
	private int id;
	private String descript;
	private String type;
	private int stamp;
	private String showtime;
	private String uploadtime;
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Goods() {
		super();
	}
	
	
}
