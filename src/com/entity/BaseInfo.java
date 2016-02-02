package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//影片详情公共部分 1的一方
public class BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7560121738505327230L;

	//private int id;
	private String base_id;
	
private String country;//上映国家

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



public String getLanguage() {
	return language;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public void setLanguage(String language) {
	this.language = language;
}

public BaseInfo(){
	
}
	
}
