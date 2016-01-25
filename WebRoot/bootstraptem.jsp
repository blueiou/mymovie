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
    <link href="./css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/examples.css" />
    <link rel="stylesheet" href="./css/base.css" />
<style type="text/css">

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
  
  
     <nav class="navbar navbar-ct-transparent navbar-fixed-top" role="navigation-demo" id="register-navbar">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navigation-example-2">
          <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#" class="btn btn-simple">Components</a>
            </li>
            <li>
                <a href="#" class="btn btn-simple">Tutorial</a>
            </li>
            <li>
                <a href="#" target="_blank" class="btn btn-simple"><i class="fa fa-twitter"></i></a>
            </li>
            <li>
                <a href="#" target="_blank" class="btn btn-simple"><i class="fa fa-facebook"></i></a>
            </li>
           </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-->
    </nav> 
    
    <div class="wrapper">
        <div class="register-background"> 
            <div class="filter-black"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                            <div class="register-card">
                                <h3 class="title">Welcome</h3>
                                <form class="register-form">
                                    <label>Email</label>
                                    <input id=""  type="text" class="form-control" placeholder="用户名">

                                    <label>Password</label>
                                    <input id="" type="password" class="form-control" placeholder="密码">
                                    <input id="" type="password" class="form-control" placeholder="重复密码">
                                    <button class="btn btn-danger btn-block">Register</button>
                                </form>
                                <div class="forgot">
                                    <a href="#" class="btn btn-simple btn-danger">Forgot password?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>     
            <div class="footer register-footer text-center">
                    <h6>&copy; 2015, made with <i class="fa fa-heart heart"></i> by</h6>
            </div>
        </div>
    </div>      
  </body>
</html>
