package com.entity;

import java.io.Serializable;
import java.util.Set;

public class Play implements Serializable {
	private String play_id;
	private String play_time;
	private double price;
	//与影片一对多
	private Goods goods;
	//与播放厅 一对多
	private Hall hall;
	//已卖出的票数
	private int sell_num;
	//与 电影票 一对多
	private Set<Ticket> tickets;
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	public int getSell_num() {
		return sell_num;
	}
	public void setSell_num(int sell_num) {
		this.sell_num = sell_num;
	}
	
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getPlay_id() {
		return play_id;
	}
	public void setPlay_id(String play_id) {
		this.play_id = play_id;
	}
	public String getPlay_time() {
		return play_time;
	}
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}
	public Play(){
		super();
	}
}
