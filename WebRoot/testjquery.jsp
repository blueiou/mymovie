<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testjquery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="script/jquery1.8.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

  <nav class="navbar navbar-default">
<form class="navbar-form navbar-left" role="search">
  <div class="form-group">
    <input type="text" class="form-control" placeholder="Search">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
</nav>
  <input type="button" onclick="checkxg()" value="小小提示库"><br>
  <button onclick="checkxg()">小小提示库换</button><br>
   <p>这是一个段落。</p>
<button id="one">切换</button><br>
<button id="tow">切换</button><br>
<button >切换</button><br>
<table>
  <tr id="s1"><td>测试</td>
  <td><input type="hidden" id="del" value="501"><button id="deldata" type="button">点我删除</button></td>
  </tr>
  </table>
    <script type="text/javascript">
   $(document).ready(function(){ 
   $("#test1").click(function(){
	   layer.open({
	        type: 1,
	        area: ['600px', '360px'],
	        shadeClose: true, //点击遮罩关闭
	        content: '\<\div style="padding:20px;">自定义内容\<\/div>'
	    });
	    //alert("nihao");
	});
   });
   $(document).ready(function(){ 
	 
	   $("button").click(function(){
	   // $("p").slideToggle();
	   var did=$(this).attr("id");
	   alert(did);
	  });
   });
   
   
 function test(obj){
		   layer.open({
		        type: 1,
		        area: ['600px', '360px'],
		        shadeClose: true, //点击遮罩关闭
		        content: '\<\div style="padding:20px;">自定义内容\<\/div>'
		    }); 
 }
 function checkxg(){
	 var str="12121313131";
	 var result=false;
	  result=str.matches("[1-2]+");
	  alert("enter");
		if (result == true) {
		alert("该字符串是纯数字");}
		else{alert("该字符串不是纯数字");}
		  // document.suiji.submit();
		 // return true;
		}
 $(document).ready(function(){ 
	 $("#deldata").click(function(){ 
	 delid = $("#del").val(); 
	 $.ajax({
	 type: "post", 
	 url: "deldata.action", 
	 dataType: "html",  
	 data: "did="+delid, 
	 success: function(result){ 
	 var res = String($.trim(result)); 
	 if(res=="ture"){
		 $("#s1").slideToggle();
         	alert("ture"); 
	 }else { 
		
     	alert("false");
	 }
	 } 
	 
	 }); 
	 });  
 });
 
 /*  $("#deldata").click(function(){
 $.get('deldata.action',
     {
 	did:501,
     },
     function(data)//回传函数
     {
         if(data=="ture") {
         	$("#s1").slideToggle();
         	alert("ture");
         }
         else {
         	alert("false");
         }
     }
 ); 
});
*/




/*  $("#showAll").blur(function(){


var str = document.getElementById("showAll").value;
alert(str);
str = str.replace(/ /g,"</td></tr><tr><td>");
str = str.replace(/,/g,"</td><td>");
var tabBegin = "<table width='600'><tr><td>";
var tabEnd = "</td></tr></table>";
str = tabBegin + str + tabEnd;
document.getElementById("showTable").innerHTML = str;


}); */
 </script> 
  </body>
</html>
