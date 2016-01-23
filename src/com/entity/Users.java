package com.entity;

public class Users {
private int uid;
private String uName;
private String uPwd;

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public String getuName() {
	return uName;
}

public void setuName(String uName) {
	this.uName = uName;
}

public String getuPwd() {
	return uPwd;
}

public void setuPwd(String uPwd) {
	this.uPwd = uPwd;
}

public Users(int uid) {
	super();
	this.uid = uid;
}

public Users() {
		// TODO Auto-generated constructor stub
	}

}
