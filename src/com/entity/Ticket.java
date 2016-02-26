package com.entity;
import java.io.Serializable;
public class Ticket implements Serializable{
	private static final long serialVersionUID = -696333430429861678L;
	private String ticket_id;//电影票ID
	private String code;//电影票号
	private String u_seat;//座位   几排几位
	private double currPrice;//实际价格
	private String date;//订票日期
	private int statue;// 付款状态 0为未付款 1为已付款
	//与场次多对一 某场次出多张电影票
	private Play play;
	//与用户多对一 -----某个用户可买多张电影票
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Play getPlay() {
		return play;
	}
	public void setPlay(Play play) {
		this.play = play;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
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

	public String getU_seat() {
		return u_seat;
	}
	public void setU_seat(String u_seat) {
		this.u_seat = u_seat;
	}
	
	public double getCurrPrice() {
		return currPrice;
	}
	public void setCurrPrice(double currPrice) {
		this.currPrice = currPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Ticket(String ticket_id) {
		this.ticket_id=ticket_id;
		// TODO Auto-generated constructor stub
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
