package com.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.service.SysTicketService;
import com.tools.CacheClass;
import com.tools.Functions;

public class TicketManagementAction extends AjaxActionSupport{

	
	private SysTicketService sTicket;
private Map<String, Object> map;
private Object reply;
	public Map<String, Object> getMap() {
	return map;
}

public void setMap(Map<String, Object> map) {
	this.map = map;
}

	public SysTicketService getsTicket() {
		return sTicket;
	}

	public void setsTicket(SysTicketService sTicket) {
		this.sTicket = sTicket;
	}
	
	
	
	public String execute() throws Exception{
		String mString=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print("tm 中m的值为："+mString);
		switch (m) {
		case Functions.TICKET_OPERATION_SEARCH_SEAT:               //1710
			return getSeats();
		default: 
			return ERROR;
		}
	}
	//只需要传递厅号和时间来即可看到相应的位置
	public String getSeats() throws UnsupportedEncodingException{
		map=new HashMap<String,Object>();
	reply=sTicket.findByTimeRoom(new String(request.getParameter("room").getBytes("ISO-8859-1"),"utf-8"), request.getParameter("playTime"));
	//reply=sTicket.findByTimeRoom(request.getParameter("play_id"));//多遍历一次的
	System.out.println(reply);
	
		map.put("seat", reply);
		map.put("success", true);
		return SUCCESS;
	}
}
