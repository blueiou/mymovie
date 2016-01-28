<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电影首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/ct-paper.css" />
  </head>
  
  <body ng-app="IndexApp">
  
  <div class="container">
         <div id="navbar">
                            <nav class="navbar navbar-default">
                              <div class="container-fluid">
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                  </button>
                                  <a class="navbar-brand" ui-sref="showing" >Menu</a>
                                </div>
                            
                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                  <ul class="nav navbar-nav">
                                    <li class="active"><a href="#">Link</a></li>
                                    <li><a href="#">Link</a></li>
                                    <li class="dropdown">
                                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
<!--                                  You can add classes for different colours on the next element -->
                                      <ul class="dropdown-menu dropdown-menu-right">
                                        <li class="dropdown-header">Dropdown header</li>
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">One more separated link</a></li>
                                      </ul>
                                    </li>
                                  </ul>
                                </div><!-- /.navbar-collapse -->
                              </div><!-- /.container-fluid -->
                            </nav>
                        
                        </div><!--  end navbar -->
  <%--   <div class="row">
    <s:iterator value="page.stulist"  var="s">




            <div class="col-md-4 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/700x400" alt="">
                </a>
                <h3>
                    <a href="#">${s.sysname}</a>
                </h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
            </div>
            </s:iterator>
            </div>
        <!-- /.row -->
        总共有${page.rowcount}条记录
总共有${page.pagecount }页
当前${page.pageno }/${page.pagecount }页<br>

${page.sb2} --%>
</div>
<hr />
<div class="nav-tabs-navigation">
                            <div class="nav-tabs-wrapper">
                            <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                                <li ><a  ui-sref="showing">正在热映</a></li>
                                <li><a ui-sref="preparatory">预备上映</a></li>
                                <li><a href="" data-toggle="tab">Messages</a></li>
                            </ul>
                            </div>
                        </div>

        <div ui-view=""></div>
        <hr />
  </body>
  
  <!-- Angular -->
  <script src="./script/angularjs/angular.js"></script>
  <script src="./script/angularjs/angular-resource.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script>
   <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <!-- UI-Router -->
  <script src="./script/angularjs/angular-ui-router.js"></script>
  <!-- App Script -->
    <script src="./script/app/apps.js"></script>
    <script src="./script/app/service.js"></script>
    <script src="./script/app/controller.js"></script>
</html>
