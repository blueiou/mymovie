<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" ></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
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
                                    <input id="uname" name=""  type="text" class="form-control" placeholder="用户名">
                                    <label>Password</label>
                                    <input id="upass" name=""  type="password" class="form-control" placeholder="密码">
                                    <button class="btn btn-danger btn-block" onclick="loginSubmit()">登录</button>
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
  <script type="text/javascript" src="./script/jquery1.8.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  //loadpage();
		  //验证用户名
	 }); 
  function loginSubmit(){
		var uname=$("#uname").val();
		var upass=$("#upass").val();
		$.ajax({
			 type: "post", 
			 url: "testU.action", 
			 dataType: "json",  
			 data: "uname="+uname+"&upass="+upass, 
			 //data: "m=1520&id=40288183529b5f4f01529b5f50840002", 
			 success: function(result){
				 var res =[];
			 res = result.user.roles; 
			 var str="administrator";
			 var str2=res[0].rolename;
			 if(str==str2) {window.location.href="test.jsp";}
			
			/* if(res=="true"){
				 $("#spuser").html("");
				 document.login.submit();
				 return true;
			 }
			 else if(res=="false"){ 
				 $("#spuser").html("<font color='#FF0000'>*用户名或密码错误</font>");
				 return false;
			 }*/
			 },error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
				 },
			 }); 
		 
		//return false;
	}
  </script>

</html>
