package com.tools;

public class PulginsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066442061959337382L;
	public int state=0;
public PulginsException(){
	super();
}

public PulginsException(String errormsg) {
	super(errormsg);
}
public PulginsException(int state,String msg){
	super(msg);
	this.state=state;
	
}
public int getState(){
	return state;
}
}
