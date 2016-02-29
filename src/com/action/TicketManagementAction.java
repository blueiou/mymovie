package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.service.SysTicketService;
import com.tools.CacheClass;
import com.tools.Functions;

public class TicketManagementAction extends AjaxActionSupport{
	private String playid;
	private double price;
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
	public String getPlayid() {
		return playid;
	}
	public void setPlayid(String playid) {
		this.playid = playid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String execute() throws Exception{
		String mString=request.getParameter("m").trim();
		int m=-1;
		if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print("tmaction中m的值为："+mString);
		switch (m) {
		case Functions.TICKET_OPERATION_SEARCH_SEAT:               //1710
			return getSeats();
		case Functions.TICKET_OPERATION_PRODUCED_ORDER:
			return getOrder();                                    //1725 生成订单
		default: 
			return ERROR;
		}
	}
	//只需要传递厅号和时间来即可看到相应的位置
	public String getSeats() throws UnsupportedEncodingException{
		map=new HashMap<String,Object>();
	reply=sTicket.findByTimeRoom(CacheClass.encodingString(request.getParameter("room")), request.getParameter("playTime"));
	//reply=sTicket.findByTimeRoom(request.getParameter("play_id"));//多遍历一次的
	System.out.println(reply);
	
		map.put("seat", reply);
		map.put("success", true);
		return SUCCESS;
	}
	//确认生成订单 
	public String getOrder() throws IOException{
		map=new HashMap<>();
		String seat1=request.getParameter("seat");
		String[] seats;
		 HttpSession session=request.getSession();
		 String uidString=(String)session.getAttribute("uid");
		if (uidString!=null&&!CacheClass.isEmpty(seat1)){
			seats=CacheClass.splitString(seat1);
			if (sTicket.saveTicket(playid,uidString,seats,price)) {
				return "showorder";
			}
		}
		else {
			return "needlogin";
			//response.sendRedirect("user/index.jsp");
		}
		return ERROR;
	}
}
