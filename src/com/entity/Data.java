package com.entity;

import java.io.Serializable;

public class Data implements Serializable{
	private String id;
	private String data;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	
	public Data(String id, String data) {
		this.id = id;
		this.data = data;
	}

	public Data()
	{
		
	}


	
	
}
