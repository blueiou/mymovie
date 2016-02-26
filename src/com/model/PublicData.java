package com.model;

import java.util.ArrayList;
import java.util.List;

import com.tools.CacheClass;



public class PublicData {

    public String name;//呢称
    public String sex;//性别，0为女性
	public String avatar;//头像
 
	private List<OrdersInfo> ordersInfo;
	
	
	public List<OrdersInfo> getOrdersInfo() {
		return ordersInfo;
	}


	public void setOrdersInfo(List<OrdersInfo> ordersInfo) {
		this.ordersInfo = ordersInfo;
	}


	public PublicData()
	{
	}


}
