package com.action;

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
	
	
	
	public String execute(){
		String mString=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print("m的值为："+mString);
		switch (m) {
		case Functions.TICKET_OPERATION_SEARCH_SEAT:               //1710
			return getSeats();
		default: 
			return ERROR;
		}
	}
	public String getSeats(){
		map=new HashMap<String,Object>();
	//reply=sTicket.findByTimeRoom(request.getParameter("room"), request.getParameter("playTime"));
	reply=sTicket.findByTimeRoom("2号厅","2016-02-23 09:55:00");
	System.out.println(sTicket.findByTimeRoom("1号厅","2016-02-23 09:55:00"));
		map.put("seat", sTicket.findByTimeRoom("1号厅","2016-02-23 09:55:00"));
		map.put("success", true);
		return SUCCESS;
	}
}
