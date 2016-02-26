package com.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CacheClass {

	public static boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0 || "null".equals(s))
			return true;
		else
			return false;
	}
public static boolean isNumValue(String pid){
	String regStr = "^[+-]?[1-9][0-9]*$|^0$";
	if(pid.matches(regStr))
		return true;
	else
		   return false;
	   
	
}
	
	public static String getStringValue(Object o) {
		if (o == null)
			return null;
		else
			return o.toString();
	}

	public static int getIntValue(String s) {
		if (isEmpty(s))
			return 0;
		else
			return Integer.parseInt(s.trim());
	}

	public static long getLongValue(String s) {
		if (isEmpty(s))
			return 0;
		else
			return Long.parseLong(s.trim());
	}

	public static float getFloatValue(String s) {
		if (isEmpty(s))
			return 0;
		else
			return Float.parseFloat(s.trim());
	}
	
	public static BigDecimal getBigDecimal(String s){
		if (isEmpty(s))
			return BigDecimal.valueOf(0);
		else
			return new BigDecimal(s.trim());
	}

	public static double getDoubleValue(String s) {
		if (isEmpty(s))
			return 0;
		else
			return Double.parseDouble(s.trim());
	}

	public static boolean myEqualsIgnoreCase(String s1, String s2) {
		if (isEmpty(s1) ) {
			if (isEmpty(s2))
				return true;
			else
				return false;

		} else {
			if(isEmpty(s2))
				return false;
			else
			return s1.equalsIgnoreCase(s2);
		}
	}

	public static boolean isMobileNO(String mobile) {
		String regExp = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}

	public static boolean isEMailNO(String mobile) {
		String regExp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}

	// 是否只含数字
	public static boolean isNO(String mobile) {
		if (isEmpty(mobile))
			return true;
		String regExp = "^[0-9]*$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}

	public static boolean isFloatNO(String mobile) {
		if (isEmpty(mobile))
			return true;
		String regExp = "\\d+\\.?\\d*";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}

	/**
	 * 判断number参数是否是整型数表示方式
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isIntegerNumber1(String number) {
		if (isEmpty(number))
			return true;
		number = number.trim();
		String intNumRegex = "\\-{0,1}\\d+";// 整数的正则表达式
		if (number.matches(intNumRegex))
			return true;
		else
			return false;
	}

	/**
	 * 判断number参数是否是正整型数表示方式
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isIntegerNumber2(String number) {
		if (isEmpty(number))
			return true;
		number = number.trim();
		String intNumRegex = "\\d+";// 整数的正则表达式
		if (number.matches(intNumRegex))
			return true;
		else
			return false;
	}

	/**
	 * 获取当前毫秒-不含日期
	 * 
	 * @param number
	 * @return
	 */
	public static int getcurTime() {
		int time = (int) ((new Date().getTime() + 8 * 60 * 60 * 1000) % (24 * 3600 * 1000)); // 换算成毫秒数，对一天的毫秒数取余，就是当天的毫秒数
		return time;
	}
	
	//毫秒数转时/分格式
	public static String mscToTimeStr(int msc){
		int hour = (msc % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);  
	    int minute = (msc % (1000 * 60 * 60)) / (1000 * 60);
	    StringBuffer timeStr = new StringBuffer();
	    if(hour < 10){
	    	timeStr.append("0").append(hour);
	    }else{
	    	timeStr.append(hour);
	    }
	    timeStr.append(":");
	    if(minute < 10){
	    	timeStr.append("0").append(minute);
	    }else{
	    	timeStr.append(minute);
	    }
	    
	    return timeStr.toString();
	}

	public static long getTime() {
		return new Date().getTime();
	}
	
	/**
     * 获取几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfterDay(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        
        return now.getTime();
    }
    
    /**
     * 返回特定格式的日期
     * 格式如下:
     * yyyy-MM-dd
     * @param format
     * @return
     */
    public static String getFormatDate(Date date, String format){
        return getDateFormat(format).format(date);
    }
    
    /**
     * 将长时间格式字符串转换为时间
     * 如: yyyy-MM-dd HH:mm:ss
     */
	public static Date strToDate(String strDate, String format) {
		try {
			return getDateFormat(format).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static SimpleDateFormat getDateFormat(String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter;
	}

	
	
	//两日期相差天数
	public static int GetDateSubDay(String d1,String d2)
	{
		if(CacheClass.isEmpty(d2)) return -1;
		int d1d2=-1;
		SimpleDateFormat smdf = new SimpleDateFormat( "yyyy-MM-dd"); 
		try { 
			Date start = smdf.parse( d1); 
			Date end = smdf.parse( d2); 
			d1d2 = (int) ((end.getTime() - start.getTime()) / (3600 * 24 * 1000)); 
 
		} catch (ParseException e) { 
			e.printStackTrace(); 
		}
		
		return d1d2;
	}
	
    //当月的第一天
	public static long getCurMonthFirstDay1()
	{
		 Date nowdate = new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(nowdate);
		 cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		 return cal.getTime().getTime();
	}
	public static Date getCurMonthFirstDay2()
	{
		 Date nowdate = new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(nowdate);
		 cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		 return cal.getTime();
	}
	
    //当月的最后一天
	public static long getCurMonthEndDay()
	{
		 Date nowdate = new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(nowdate);
		 cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		 return cal.getTime().getTime();
	}	
	

	// YYYY-MM-DD 日期格式验证
	public static boolean isValidDate(String sDate) {
		String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
		String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
				+ "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
				+ "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
				+ "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		if ((sDate != null)) {
			Pattern pattern = Pattern.compile(datePattern1);
			Matcher match = pattern.matcher(sDate);
			if (match.matches()) {
				pattern = Pattern.compile(datePattern2);
				match = pattern.matcher(sDate);
				return match.matches();
			} else {
				return false;
			}
		}
		return false;
	}

	// 根据生日计算年龄
	public static String getAge(String birthday_) {
		if (isEmpty(birthday_))
			return null;
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay = null;
		try {
			birthDay = myFormatter.parse(birthday_);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}

		return age + "";
	}

	public static boolean checkPage(String str){
		boolean result=str.matches("[0-9]+");
		if (result == true) return true;
		else return false;
	}

	public static boolean checkData(String str){
		boolean result=str.matches("[1-2]+");
		if (result == true) {
		return true;}
		else return false;
	}
	public static boolean checkUN(String str){
		return str.matches("[A-Za-z0-9_]+");
		
	}
	public static  String encodingString(String s) throws UnsupportedEncodingException{
		String ss=null;
	if(!isEmpty(s))	ss=new String(s.getBytes("ISO-8859-1"),"utf-8");
		return ss;
	}
	//分割字符串   传来的座位是这样的字符串
	public static String[] splitString(String aString){
		String bStrings=aString.trim().substring(2,aString.length()-2);
		String[] cStrings=bStrings.split("\",\"");
		return cStrings;
	}
	public static boolean checkId(String pid){
		String regStr = "^[+-]?[1-9][0-9]*$|^0$";
		if(pid.matches(regStr)){
			return true;
		   }else{
			   return false;
		   }
	}
}
