package com.entity;
//影片详情公共部分
public class BaseInfo {
	private int id;
	
private String contry;//上映国家

private String language;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getContry() {
	return contry;
}

public void setContry(String contry) {
	this.contry = contry;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public BaseInfo(){
	
}
	
}
