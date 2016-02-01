package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import javax.servlet.AsyncContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OutPrintClass {
	/*	
	public static String readJSONString(HttpServletRequest request) {

		String json = request.getParameter("data");
		
		System.out.println(json);
		
		return json;
		
	}
	
	*/

	
	public static String readJSONString(HttpServletRequest request) {
		
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			line=null;
			return line;
		}
		try {
			 line=json.toString();
			 line=URLDecoder.decode(line, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			line=null;
			return line;
		}
		

		 /*if(line.startsWith("date="))
			 line=line.substring(5, line.length());*/
		System.out.println("收到:"+line);
		
		return line;
		
	}
}
	
	