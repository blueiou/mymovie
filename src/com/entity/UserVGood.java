package com.entity;

import java.io.Serializable;

public class UserVGood implements Serializable{

	private String userid;
	private String good_id;
	
	private String content;


	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getGood_id() {
		return good_id;
	}

	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserVGood() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
