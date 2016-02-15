package com.entity;

import java.io.Serializable;

public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -696333430429861678L;
	private String ticket_id;
	private String code;//电影票号
	private String seat;//座位
	private String currPrice;//实际价格
	private String date;//订票日期
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getCurrPrice() {
		return currPrice;
	}
	public void setCurrPrice(String currPrice) {
		this.currPrice = currPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
