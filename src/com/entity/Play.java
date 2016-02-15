package com.entity;

import java.io.Serializable;
import java.util.Set;

public class Play implements Serializable {
	private String play_id;
	private String play_time;
	private double price;
	
	private Goods goods;
	
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
