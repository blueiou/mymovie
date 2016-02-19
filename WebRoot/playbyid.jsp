<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'playbyid.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  <body>
  <div class="container">
 <p>今日上映  :</p>
  <table class="table"> 
  <thead>
  <tr>
  <th>放映时间</th>
  <th>语言</th>
  <th>片长</th>
  </tr>
  </thead>
   <s:iterator value="#request.dataMap.reply" id="n">
  <tr>
<td><s:property value="#n.sysname"/></td> 
<td><s:property value="#n.playtime"/></td> 
<td><s:property value="#n.price"/>    </td> 

 </tr>
 </s:iterator>
 </table>
   </div>
  </body>
</html>
   <%-- <!-- //双层循环取值 -->
   <s:iterator value="#request.dataMap.reply" id="n">
<s:iterator value="#n" id="s"> 
<s:property value="#s"/>     
 </s:iterator> 
</s:iterator> --%>
   <!-- //双层循环取值 -->