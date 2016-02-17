package com.model;

public class GoodVPlayVHall {

	private String name;
	private String time;
	private String hall;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public GoodVPlayVHall(String name, String time, String hall) {
		super();
		this.name = name;
		this.time = time;
		this.hall = hall;
	}
	public GoodVPlayVHall() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
