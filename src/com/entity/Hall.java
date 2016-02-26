package com.entity;

import java.io.Serializable;
import java.util.Set;

public class Hall implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -2972907068930528292L;
private int hall_id;
private String roomname;
private String version;//放映的版本 
//一个播放厅播放多个场次的电影
private Set<Play> play;
private int seat;//一个放映厅的座位数


public int getSeat() {
	return seat;
}
public void setSeat(int seat) {
	this.seat = seat;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public Set<Play> getPlay() {
	return play;
}
public void setPlay(Set<Play> play) {
	this.play = play;
}
public String getRoomname() {
	return roomname;
}
public int getHall_id() {
	return hall_id;
}
public void setHall_id(int hall_id) {
	this.hall_id = hall_id;
}
public void setRoomname(String roomname) {
	this.roomname = roomname;
}
public Hall() {
	super();
}

	
}
