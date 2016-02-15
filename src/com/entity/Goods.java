package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public  class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2607137354064922704L;
	private String sysname;
	private String  good_id;
	private String descript;
	private String type;
	private int stamp;
	private String showtime;
	private String uploadtime;
	private BaseInfo baseInfo;
	
	//与场次多对一   播放多场同一部电影
	private Set<Play> play;
	
	

	
	public Set<Play> getPlay() {
		return play;
	}
	public void setPlay(Set<Play> play) {
		this.play = play;
	}
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
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
