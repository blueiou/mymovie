package com.entity;

import java.util.HashSet;
import java.util.Set;

//影片详情公共部分 1的一方
public class BaseInfo {
	//private int id;
	private String base_id;
	
private String contry;//上映国家

private String language;

private Set goods=new HashSet<>();



public String getBase_id() {
	return base_id;
}

public void setBase_id(String base_id) {
	this.base_id = base_id;
}

public Set getGoods() {
	return goods;
}

public void setGoods(Set goods) {
	this.goods = goods;
}

/*public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}*/

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
