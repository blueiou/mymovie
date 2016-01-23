<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="script/jquery1.8.js"></script>
	<link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">
    <script src="script/jquery.mobile-1.3.2.min.js"></script>
   <script type="text/javascript" src="script/ulogin.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet">
  </head>
  
  <script src="script/jquery.js" type="text/javascript"></script>
 
  <script type="text/javascript">
  
   function checkdatas(){
	  var username = $("#udatas").val();
	  if (username.match( /^[0-9]{66,20}$/)) {
		  $("#spdatas").html(" ");
		 return true;
	  }
	  else {
		  $("#spdatas").html("<font color='#FF0000'>*只能输入数字，请重新输入</font>");  
		//  layer.msg("用户名只能是字母、数字和下划线，请重新输入");
		  return false;
	  }
  }
   
   
   $(document).ready(function(){ 
	   $("#addSubmit").click(function(){
	   var udata=$("#udatas").val();
	   $.ajax({
			 type: "post", 
			 url: "adddatas.action", 
			 dataType: "html",  
			 data: "udata="+udata, 
			 success: function(result){ 
			 var res = String($.trim(result)); 
			 
			 if(res=="true"){
				 
		         	alert("添加成功"); 
			 }else { 
	         	alert("添加失败");
			 }
			 } 
			 });
	   });
   });
   </script>
  
  <body>
     <!-- res nav -->
    <%@include file="check.jsp" %>
  <!-- nav -->
  <div data-role="page">
  <div data-role="header">
  <a href="datapage.action" data-role="button" data-icon="home">首页</a>
  <h1>添加数据</h1>
  </div>

  <div data-role="content">
   
      <div data-role="fieldcontain">
        <label for="fullname">输入数据：</label>
        <input type="text" name="udatas" id="udatas" onchange="checkdatas()">       
      </div>
      <input type="button" data-inline="true" value="提交" id="addSubmit">
      
  </div>
</div>
  </body>
</html>
