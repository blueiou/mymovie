<%@page import="com.entity.SpiltData"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>重新排列后的结果显示</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">
    <script src="script/jquery.mobile-1.3.2.min.js"></script>
 <%
  char[][]  newDatas  =  (char[][])request.getAttribute("newchar2");
     %>
     <%@taglib uri="/struts-tags" prefix="s"%>
  </head>
  
  <body>
     <!-- nav -->
  <%@include file="menu.jsp"%> 
  <!-- nav -->
  <div style="text-align: center;margin: auto;width: 100%;margin-top: 100px;">
   
    <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">重新排列后结果详情</div>
   <table  class="table table-condensed" >
   <%
   
   //char[][] newchar2=new char[6][10];
for(int i=0;i<newDatas.length;i++){
%>
        <tr>
<%
for(int j=0;j<newDatas[i].length;j++){
%>
        <td class="success"><%= newDatas[i][j]%></td>
<%
}
%>
     </tr>  
<%
}
%>
 
   </table>
   </div>
   </div>
  </div>
  </body>
</html>
