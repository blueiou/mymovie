package com.entity;

import java.util.Set;

public class Hall {
private int hall_id;
private String roomname;
private Set<Play> play;

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
