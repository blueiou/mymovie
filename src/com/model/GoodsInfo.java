package com.model;

import java.io.Serializable;

import com.entity.Goods;

public class GoodsInfo implements Serializable{

	private String sysname;
	private int id;
	private String descript;
	private String type;
	private int stamp;
	private String showtime;
	private String uploadtime;
	private Goods goods;
	
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
	public GoodsInfo(){
		super();
	}
	public GoodsInfo(String sysname, int id, String descript, String type,
			String showtime, String uploadtime) {
		super();
		this.sysname = sysname;
		this.id = id;
		this.descript = descript;
		this.type = type;
		this.showtime = showtime;
		this.uploadtime = uploadtime;
	}
	public GoodsInfo(String sysname, int id, String descript) {
		super();
		this.sysname = sysname;
		this.id = id;
		this.descript = descript;
	}
	
}
