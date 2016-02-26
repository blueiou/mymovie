package com.model;

import com.entity.Goods;

public class SysGoodsData extends Goods{

	//获取用户对影片的评论 msg
	/**
	 * 
	 */
	private static final long serialVersionUID = 7294265406064389073L;
	private  String msg;
 private String name;
 
	public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public SysGoodsData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
