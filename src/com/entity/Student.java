package com.entity;

import java.io.Serializable;

public class Student implements Serializable{

	private int stuid;
	private String stuname;
	private String stusex;
	private String stuclass;
	

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStusex() {
		return stusex;
	}

	public void setStusex(String stusex) {
		this.stusex = stusex;
	}

	public String getStuclass() {
		return stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

public Student(){
	
}

public Student(int id,int stuid,String stuname,String stusex,String stuclass){
	
	this.stuid=stuid;
	this.stuname=stuname;
	this.stusex=stusex;
	this.stuclass=stuclass;
	
}
}
