package com.entity;

public class UserInfo {

	private String content;
	private String u_id;
	private String m_id;
	private User	user;
	//private Goods goods;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
