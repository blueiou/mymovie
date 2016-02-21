<%@page import="com.entity.Role"%>
<%@ page language="java" import="java.util.*,com.tools.CacheClass" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  //当前用户是否登陆
  if(CacheClass.isEmpty((String)session.getAttribute("uid")))
  { 
  			//request.setAttribute("errMessage","请重新登陆");
			//response.sendRedirect("../user/login.jsp");
			//response.sendRedirect("test.html");
			out.print("管理员未登录");
			return;
   }else
 {
	   Set<Role> roleSet=new HashSet();
	   Set<String> roleString=new HashSet();
	         roleSet=(Set)session.getAttribute("urole");
	         Iterator iterator=roleSet.iterator();// 获得一个迭代子
	 		while (iterator.hasNext()) {
	 			Role role2=(Role) iterator.next();
	 			System.out.println(" role2.getRolename()"+role2.getRolename());
	 			roleString.add(role2.getRolename());
	 		}
	 	  if(roleString.contains("administrator")){
	 		  out.print("超级管理员");
	 	  }
	 	  if(roleString.contains("manager")){
	 		  out.print("普通管理员");
	 	  }
	 	  if(roleString.contains("generalUser")){
	 		  
	 		  out.print("普通用户");
	 	  }
}


%>
  <body>
    This is my JSP page. <br>
  </body>
</html>
