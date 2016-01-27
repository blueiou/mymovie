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
		DateFormat df = new SimpleDateFormat("yyyyMMdd:HH:mm:ss:SSS");
		return df.format(this);
	}

}
