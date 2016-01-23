<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据</title>
    
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
   <div class='alert alert-info' role='alert'>修改数据</div>
   <form name="suiji"  action="" method="post" >
   <input type='text' name='param' id='param' class='form-control' placeholder='Search for...'>
   
   </form>
   
   
   <span class='input-group-btn'><button class='btn btn-default' type='button' id='sjss' onclick='checksj()'>随机搜索</button></span>
   
   
   
   
  </body>
</html>
