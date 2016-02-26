package com.entity;

import java.io.Serializable;

public class IndexGoods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2409414419893064045L;
	private String sysname;
	private String  good_id;
	private String descript;
	private String type;
	private int stamp;
	private String showtime;
	private String uploadtime;
	private BaseInfo baseInfo;
	
	private String playbillurl;

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getGood_id() {
		return good_id;
	}

	public void setGood_id(String good_id) {
		this.good_id = good_id;
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

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getPlaybillurl() {
		return playbillurl;
	}

	public void setPlaybillurl(String playbillurl) {
		this.playbillurl = playbillurl;
	}

	public IndexGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
