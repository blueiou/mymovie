<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="../../menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>选座场次</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body ng-app="IndexApp">
  <div class="container">
 <p>今日上映  :</p>
  <table class="table table-hover"> 
  <thead>
  <tr class="success">
  <th class="column t-price">放映时间</th>
  <th class="column t-price">语言</th>
  <th class="column t-price">版本</th>
  <th class="column t-price">片长</th>
  <th class="column t-price">影厅空位</th>
  <th class="column t-price">价格</th>
  </tr>
  </thead>
   <s:iterator value="dataMap.reply" id="n">
  <tr>
  <td>${n.playtime}</td> 
<td>${n.language}</td> 
<td>${n.version}</td> 
<td>商品ID>>${n.good_idString}</td> 
<td>场次ID>>${n.play_idString}</td>
<%-- <td><s:property value="#n.playtime"/></td> 
<td><s:property value="#n.language"/></td> 
<td><s:property value="#n.version"/></td> 
<td>商品ID>><s:property value="#n.good_idString"/></td> 
<td>场次ID>><s:property value="#n.play_idString"/></td> --%> 
<%-- <td><a href="movies/seats/bookseat.jsp?room=${n.roomname}&time=${n.playtime}">选择座位</a></td>  --%>
<td><a ui-sref="bookseat({id:'${n.play_idString}',room:'${n.roomname}',time:'${n.playtime}',price:'${n.price}'})">选择座位</a></td> 
<%-- <td><a ui-sref="bookseat({id:'${n.play_idString}'})">选择座位</a></td>  --%>
 </tr>
 </s:iterator>
 </table>
   </div>
   <div ui-view></div>
  <script src="./script/angularjs/angular.js"></script> 
    <script src="./script/angularjs/angular.min.js"></script>
    <script src="./script/angularjs/angular-resource.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script>
   <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <!-- UI-Router -->
  <script src="./script/angularjs/angular-ui-router.js"></script> 
  <!-- UI-Router -->
    <script src="./script/app/app.js"></script>
    <script src="./script/app/service.js"></script>
    <script src="./script/app/filter.js"></script>
       <script src="./script/app/controller.js"></script>
  </body>
</html>
   <%-- <!-- //双层循环取值 -->
   <s:iterator value="#request.dataMap.reply" id="n">
<s:iterator value="#n" id="s"> 
<s:property value="#s"/>     
 </s:iterator> 
</s:iterator> --%>
   <!-- //双层循环取值 -->