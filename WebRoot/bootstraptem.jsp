<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有的组件集合</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" ></script>
<link rel="stylesheet" href="css/bootstrap.css" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
.navbar .navbar-nav > li > a.btn-primary, .btn-primary {
    border-color: #7A9E9F;
    color: #f4f4f4;
}
.navbar .navbar-nav > li > a.btn-primary.btn-fill, .btn-primary.btn-fill {
    color: #FFFFFF;
    background-color: #7A9E9F;
    opacity: 1;
    filter: alpha(opacity=100);
}
.btn, .navbar .navbar-nav > li > a.btn {
    border-radius: 20px;
    box-sizing: border-box;
    border-width: 2px;
    background-color: transparent;
    font-size: 16px;
    font-weight: 500;
    padding: 7px 18px;
    border-color: #66615B;
    color: #66615B;
    -webkit-transition: all 150ms linear;
    -moz-transition: all 150ms linear;
    -o-transition: all 150ms linear;
    -ms-transition: all 150ms linear;
    transition: all 150ms linear;
}
body {
  color: #66615b;
  font-size: 16px;
  font-family: 'Montserrat', "Helvetica", Arial, sans-serif;
  }
</style>
  </head>
  
  <body>
  <div class="col-md-8 col-md-offset-2">
  <button class="btn btn-primary" >Default</button>
  <button class="btn btn-fill btn-primary">Primary</button>
  </div> 	
  <div class="col-sm-3"><input type="checkbox" class="checkbox" /></div>
  </body>
</html>
