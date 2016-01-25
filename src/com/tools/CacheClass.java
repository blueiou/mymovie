package com.tools;

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
	
	public static int isOut=0;  //0外网   1测试外网  2内网 
	
	public static int iscrypt=0; //0不加密   1加密  

	
	public static String imgUrl2="http://192.168.0.188:8080/";
	public static String imgUrl1="http://image.lank498.com/";
	public static String imgUrl0="http://image.lank498.com/";	
	
	public static String webUrl2="http://192.168.0.188:8080/";
	public static String webUrl1="http://www.lank498.com/";
	public static String webUrl0="http://www.lank498.com/";	
	
	
    public static final int SYSTEM = 17;
    public static final int ROSTER = 18;
    public static final int OFFLINE = 19;
    public static final int MUC_ROOM = 23;
    public static final int SECURITY_AUDIT = 25;
    public static final int MUC_SERVICE = 26;

    public static final long SECOND = 1000;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long WEEK = 7 * DAY;
	
    
    public static String isLogin(HttpServletRequest request,HttpServletResponse response)
    {
    	/*HttpSession session=request.getSession();
    	String Session_Userid=(String)session.getAttribute("userid");
 
    	String selfSessionId=getCookieSession(request);
		String cookie_Userid=SessionCacheManager.getInstance().GetSessionCache(selfSessionId);
		
		if(!CacheClass.isEmpty(Session_Userid) && !CacheClass.isEmpty(cookie_Userid) && CacheClass.myEqualsIgnoreCase(Session_Userid, cookie_Userid))
		{
			return Session_Userid;
		}
		else if(!CacheClass.isEmpty(Session_Userid) && CacheClass.isEmpty(cookie_Userid))
		{
			selfSessionId=session.getId();
			SessionCacheManager.getInstance().PutSessionCache(selfSessionId, Session_Userid);
			setCookieSession(response,selfSessionId);
			session.setAttribute("selfSessionId", selfSessionId);
			return Session_Userid;
		}
		else if(CacheClass.isEmpty(Session_Userid) && !CacheClass.isEmpty(cookie_Userid))
		{
			session.setAttribute("userid",cookie_Userid);
			
			selfSessionId=session.getId();
			SessionCacheManager.getInstance().PutSessionCache(selfSessionId, Session_Userid);
			setCookieSession(response,selfSessionId);
			session.setAttribute("selfSessionId", selfSessionId);
			
			return cookie_Userid;
		}*/
	
		return null;

    }
    
    
    public static void outLogin(HttpSession session,String selfSessionId)
    {
    	
		/*SessionCacheManager.getInstance().ClearObjectCache(selfSessionId);
		session.setAttribute("userid", "");
		session.setAttribute("selfSessionId", "");
		session.invalidate();*/

    }
    
 /*   public static void Login(HttpSession session,String selfSessionId,UserAuthDataClass tmp)
    {
    	
		SessionCacheManager.getInstance().PutSessionCache(selfSessionId, tmp.id);
		session.setAttribute("userid", tmp.id);
		session.setAttribute("userclass", tmp);
		session.setAttribute("selfSessionId", selfSessionId);
		System.out.print("login 登陆成功 sessionId="+selfSessionId+" userid="+tmp.id);
    }*/
  
    public static String getCookieSession(HttpServletRequest request)
	{
		
		Cookie[]   cookies = request.getCookies();
        //cookies不为空     
        if(cookies!=null)      
        {    
    	  for(Cookie cookieTemp : cookies){
              String   cookieIdentity = cookieTemp.getName();      
              //查找身份串      
              if(cookieIdentity.equals("selfSession"))      
              {   
            	  return  cookieTemp.getValue();
              }  
    	   }
        } 
        return null;
	}
	
    public static HttpServletResponse setCookieSession(HttpServletResponse response,String SessionId)
	{
		Cookie selfSession = new Cookie("selfSession",SessionId);
		
		selfSession.setDomain(getHost());

		response.addCookie(selfSession);
       
		return response;
	}

    
	public static int getCharacterPosition(String src, String find, int num) {
		// 这里是获取"find"符号的位置
		Matcher slashMatcher = Pattern.compile("find").matcher(src);
		int mIdx = 0;
		while (slashMatcher.find()) {
			mIdx++;
			// 当"#"符号第num次出现的位置
			if (mIdx == num) {
				break;
			}
		}
		if (mIdx == num)
			return slashMatcher.start();
		else
			return -1;

	}

	// 解析封装json格式客户端参数
	/*public static List<RecvData> getObjectList(String jsonString,
			Class<RecvData> cls) {
		if (isEmpty(jsonString))
			return null;
		List<RecvData> list = new ArrayList<RecvData>();
		try {
			list = JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
		}
		return list;
	}*/
	

	private static double EARTH_RADIUS = 3956 * 2;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static String GetDistance(double lat1, double lng1, double lat2,
			double lng2) {

		double s = calculateDistance(lat1, lng1, lat2,lng2);

		if (s > 1) {
			DecimalFormat df = new DecimalFormat("###.0");// 保留一位小数
			return df.format(s) + "千米";
		} else {
			DecimalFormat df = new DecimalFormat("###");// 保留0位小数
			return df.format(s * 1000) + "米";

		}

	}
	
	public static double calculateDistance(double startlat, double startlon, double endlat,double endlon){
		double radLat1 = rad(startlat);
		double radLat2 = rad(endlat);
		double a = radLat1 - radLat2;
		double b = rad(startlon) - rad(endlon);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		
		return s;
	}

	public static String formatGPSDistance(String s) {
		if (s == null) {
			return "";
		}
		float distance = getFloatValue(s);
		if (distance > 1) {
			DecimalFormat df = new DecimalFormat("###.0");// 保留一位小数
			return df.format(distance) + "千米";
		} else {
			DecimalFormat df = new DecimalFormat("###");// 保留0位小数
			return df.format(distance * 1000) + "米";

		}

	}
	public static String getImgUrl()
	{
		if(isOut==2)
			return imgUrl2;
		else if(isOut==1)
			return imgUrl1;
		else 
			return imgUrl0;
	}
	
	public static String getDomain()
	{
		if(isOut==2)
			return webUrl2;
		else if(isOut==1)
			return webUrl1;
		else 
			return webUrl1;
	}
	
	public static String getHost()
	{
		String webUrl=getDomain();

		if(webUrl.startsWith("http://") || webUrl.startsWith("https://"))
		{
			webUrl=webUrl.substring(webUrl.indexOf("//")+2);
		}
		if(webUrl.endsWith("/"))
			webUrl=webUrl.substring(0,webUrl.length()-1);
		if(webUrl.indexOf(":")>-1){
			webUrl=webUrl.split(":")[0];
		}
		return webUrl;
	}

	/*public static String getClassPath()
	{
		 String path = DbConnectionManager.class.getResource("/").getPath().toString();
	     if(isOut==2){
	    	 return path ;
	     }
	     else
	     {
	    	 return "/"+path ;
	     }
	}*/
	// 是否派送范围坐标
	public static boolean isArriveGPS(double lat, double lon) {
		// 七星区
		// 110.3080993 110.349783
		// 25.303348 25.254862

		if (CacheClass.isRangeDouble(lat, 25.303348, 25.254862)
				&& CacheClass.isRangeDouble(lon, 110.3080993, 110.349783)) {
			return true;
		}
		return false;
	}

	// 产生一个随机数
	public static int getRandomNum(int minPort, int maxPort) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("随机数计算,sleep出错");
		}
		int freePort = (int) (minPort + Math.round(Math.random()
				* (maxPort - minPort)));
		return freePort;
	}

	public static long getRandomNum(long minPort, long maxPort) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("随机数计算,sleep出错");
		}
		long freePort = (long) (minPort + Math.round(Math.random()
				* (maxPort - minPort)));
		return freePort;
	}
	
	//100000--999999之间的6位随机数
	public static String get6RandomCode(){
		return Math.round(Math.random() * 899999 + 100000)+"";
	}
	
	//10--99之间的2位随机数
	public static String get2RandomCode(){
		return Math.round(Math.random() * 89 + 10)+"";
	}
	
	public static float getRandomCode(int min,int max){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  Math.round(Math.random() * (max-min) + min);
	}

	public static boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0 || "null".equals(s))
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
	
	
	/**
	 * 判断number参数是否是浮点数表示方式
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isFloatPointNumber1(String number) {
		if (isEmpty(number))
			return true;
		number = number.trim();
		String pointPrefix = "(\\-|\\+){0,1}\\d*\\.\\d+";// 浮点数的正则表达式-小数点在中间与前面
		String pointSuffix = "(\\-|\\+){0,1}\\d+\\.";// 浮点数的正则表达式-小数点在后面
		String pointSuffix2 = "(\\-|\\+){0,1}\\d+";// 浮点数的正则表达式-无小数点
		if (number.matches(pointPrefix) || number.matches(pointSuffix)
				|| number.matches(pointSuffix2))
			return true;
		else
			return false;
	}

	/**
	 * 判断number参数是否是正浮点数表示方式
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isFloatPointNumber2(String number) {
		if (isEmpty(number))
			return true;
		number = number.trim();
		String pointPrefix = "\\d*\\.\\d+";// 浮点数的正则表达式-小数点在中间与前面
		String pointSuffix = "\\d+\\.";// 浮点数的正则表达式-小数点在后面
		String pointSuffix2 = "\\d+";// 浮点数的正则表达式-无小数点
		if (number.matches(pointPrefix) || number.matches(pointSuffix)
				|| number.matches(pointSuffix2))
			return true;
		else
			return false;
	}

	/**
	 * 判断number参数是否在规定值范围内
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isRangeDouble(Double number, Double min, Double max) {
		if (number >= min && number <= max)
			return true;
		else
			return false;
	}

	public static boolean isRangeInt(long number, long min, long max) {
		if (number >= min && number <= max)
			return true;
		else
			return false;
	}

	public static boolean isRangeStringLength(String s, int min, int max) {
		if (s.length() >= min && s.length() <= max)
			return true;
		else
			return false;
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

	// ****************************************lz
	// 基础资料
/*	public static BaseDataCacheManager getSYS_BaseDataCacheManager() {
		return BaseDataCacheManager.getInstance();
	}

	public static mobile_codeCacheManger getMobileCodeCacheManger() {
		return mobile_codeCacheManger.getInstance();
	}

	// wawa_table_ide 各物品表的表标识与ID计数
	public static table_ideCacheManager getSYStable_ideCacheManager() {
		return table_ideCacheManager.getInstance();
	}

	// Adv_CacheManager
	public static Welcome_CacheManager getSYSAdv_CacheManager() {
		return Welcome_CacheManager.getInstance();
	}


	public static Verson_CacheManager getSYS_VersonCacheManager() {
		return Verson_CacheManager.getInstance();
	}

	public static shop_CacheManager getSYS_ShopCacheManager() {
		return shop_CacheManager.getInstance();
	}


	public static Order_CacheManager getSYS_OrderCacheManager() {
		return Order_CacheManager.getInstance();
	}

	public static sys_viplevel_CacheManager getSys_viplevel_CacheManager() {
		return sys_viplevel_CacheManager.getInstance();
	}
	
	// *******************************************************************************
	// wawa_user_auth 人物注册验证
	public static userAuthCacheManager getUSERuserAuthCacheManager() {
		return userAuthCacheManager.getInstance();
	}



	// user_setCacheManager 人物上下线
	public static user_offline_CacheManager getUSERuser_OfflineCacheManager() {
		return user_offline_CacheManager.getInstance();
	}

	// user_setCacheManager 人物地址
	public static user_addressCacheManager getUSER_addressCacheManager() {
		return user_addressCacheManager.getInstance();
	}


	// 店铺 地址_联系人_电话
	// 订单 地址_电话_联系人
	public static String[] pressAddress(String address)
			throws LzPluginException {
		String[] result = address.split("_");
		if (result.length != 3) {
			throw new LzPluginException(address + ":地址_联系人_电话--解析错误");
		}

		return result;
	}*/
	

	public final static int 	INTEGRAL_RATE=100;			//金额换算积分比率
	public final static float 	MONEY_RATE=0.01f;			//积分换算金额比率

	public static int MoneyToScore(String money) {
		return (int)( CacheClass.getFloatValue(money) * INTEGRAL_RATE );
	}

	public static int MoneyToScore(float money) {
		return (int)(money * INTEGRAL_RATE);
	}

	public static float ScoreToMoney(int score) {
		return (score) * MONEY_RATE;
	}
	
	public static BigDecimal getDiscount(String activite){
		BigDecimal discount = BigDecimal.valueOf(1);
		String[] sps = activite.split(";");
		for(String sp : sps){
			if(sp.indexOf("折扣") > 1){
				discount = BigDecimal.valueOf(getDoubleValue(sp.split("/")[1])/100);
			}
		}
		return discount;
	}
	
	public static void main(String[] args){
		System.getProperties().list(System.out);  
	}
	
	public static int getmyid(String id_str)
	{
		if(id_str.contains("_"))
		{
			id_str=id_str.substring(0, id_str.indexOf("_"));
		}
		
		return getIntValue(id_str);
	}
	
	public static String getmyidStr(String id_str)
	{
		if(id_str.contains("_"))
		{
			id_str=id_str.substring(0, id_str.indexOf("_"));
		}
		
		return id_str;
	}
}
