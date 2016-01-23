<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter, java.sql.Connection
, java.sql.DriverManager,
 java.sql.SQLException"%>




<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'exception.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
 Connection cn=null;
		  try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		    out.print("加载驱动成功"+"<br/>");
		  }
		  catch(Exception e){
		   out.println("加载驱动失败"+e.getMessage()+"<br/>");
		  }
		  try{
		   String url="jdbc:mysql://localhost:3306/test";//将汉字输入到数据库很关键
		   String user="test";
		   String password="test";
		   cn=DriverManager.getConnection(url,user,password);
		    out.print("数据库连接成功"+"<br/>");
		  }
		  catch(SQLException e){
		  e.printStackTrace();
		  //e.getMessage();
		   out.print("数据库连接失败Error:"+e.toString());
		  }
   %>
 <%
 
  %>
   
  </body>
</html>
