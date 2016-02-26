package com.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate extends Date {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3242778695393509953L;
	public String toString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");
		return df.format(this);
	}
	public String getYMD() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		return df.format(this);
	}
	//获取不包含毫秒的时间
	public String getYMDHMS(){
		
		DateFormat dfDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		return dfDateFormat.format(this);
	}
	public String getYMDHM(){
		DateFormat dFormat=new SimpleDateFormat("yyyyMMddHHmm");
		return dFormat.format(this);
	}
	public static int getRandomN(){
		int i=10+(int) (Math.random()*90);
		return i;
	}
	
}
