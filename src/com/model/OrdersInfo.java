package com.model;


public class OrdersInfo {
	private String ticketid;
private String mv_name;
private String showtime;
private int statue;

public String getTicketid() {
	return ticketid;
}
public void setTicketid(String ticketid) {
	this.ticketid = ticketid;
}
public int getStatue() {
	return statue;
}
public void setStatue(int statue) {
	this.statue = statue;
}
public String getMv_name() {
	return mv_name;
}
public void setMv_name(String mv_name) {
	this.mv_name = mv_name;
}
public String getShowtime() {
	return showtime;
}
public void setShowtime(String showtime) {
	this.showtime = showtime;
}
public OrdersInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public OrdersInfo(String mv_name, String showtime, int statue) {
	super();
	this.mv_name = mv_name;
	this.showtime = showtime;
	this.statue = statue;
}
public OrdersInfo(String ticketid, String mv_name, String showtime, int statue) {
	super();
	this.ticketid = ticketid;
	this.mv_name = mv_name;
	this.showtime = showtime;
	this.statue = statue;
}

}
