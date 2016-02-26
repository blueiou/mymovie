<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%
/* request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8"); */
String room=new String(request.getParameter("room").getBytes("ISO-8859-1"),"utf-8");
String time=(String)request.getParameter("time");

%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
  <head>
    <meta charset="utf-8">
    <title>在线选座</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css(.) styles/vendor.css -->
    <!-- bower:css -->
    <!-- endbower -->
    <!-- endbuild -->
    <!-- build:css(.tmp) styles/main.css -->
    <link rel="stylesheet" href="movies/seats/styles/main.css">
    <!-- endbuild -->
  </head>
    <!--[if lt IE 7]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <!-- Add your site or application content here -->
    <div class="container">
    <div ng-include="'movies/seats/views/main.html'" ng-controller="chooseSeat"></div>
    </div>
    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID -->
    <!-- bower:js -->
    <!-- endbower -->
    <!-- endbuild -->
        <!-- build:js({.tmp,app}) scripts/scripts.js -->
        <!-- <script src="scripts/app.js"></script>
        <script src="scripts/controllers/main.js"></script> -->
        <!-- endbuild -->
</body>
</html>
