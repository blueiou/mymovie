<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testpaging.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
  </head>
  
  <body ng-app="ui.bootstrap.demo">
    This is my JSP page. <br>
    <div ng-controller="PaginationDemoCtrl">
    

    <hr />
    <h4>Limit the maximum visible buttons</h4>
    <h6><code>rotate</code> defaulted to <code>true</code>:</h6>
    <uib-pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" num-pages="numPages"></uib-pagination>
    
    <h6><code>boundary-link-numbers</code> set to <code>true</code> and <code>rotate</code> set to <code>false</code>:</h6>
    <uib-pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false"></uib-pagination>
    <pre>Page: {{bigCurrentPage}} / {{numPages}}</pre>

</div>
  </body>
  <script src="./script/angularjs/angular.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script>
  <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <script src="./script/exmaple.js"></script>
</html>
