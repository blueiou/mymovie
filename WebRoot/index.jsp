<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
	<link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <script src="script/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
 $("#button").click(function(){
 alert();
 });

 
function checksj(){
   var param = document.getElementById("param").value;
  // var params = document.getElementById("params").value;
   if(param == ""  ){
     alert("随机搜索不能为空");
     return false;
   }
   /* if(params == ""  ){
    alert("不能为空");
     return false;
   } */
   document.suiji.submit();
  return true;
}
function checkzd(){

  var params = document.getElementById("params").value;
 
  if(params == ""  ){
    alert("指定搜索不能为空");
     return false;
   } 
   document.zhiding.submit();
  return true;
}
</script>  
  <body>
  <!--  <form action="datalist.action" method="post">
   <input type="text" name="param">
   <input type="submit" value="随机搜索">
   </form>
    <form action="specitfdata.action" method="post">
   <input type="text" name="params" >
    
   <select name="sChar" id="sChar">
	     <option value="*">*</option>
	     <option value="**">**</option>
	     <option value="**">***</option>
	     <option value="**">****</option>
	     </select>
   <input type="submit" value="指定搜索">
   </form> -->
   <div style="margin-right: 100px;">
 
  <div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <form name="suiji"  action="datalist.action" method="post" onsubmit = "return checksj();">
   <input type="text" name="param" id="param" class="form-control" placeholder="Search for...">
       </form><span class="input-group-btn">
      <button class="btn btn-default" type="button"  onclick="checksj()">随机搜索</button>
      </span>
    </div><!-- /input-group -->
      </div><!-- /.col-lg-6 -->
    <div class="col-lg-6">
    <div class="input-group">
        <form action="specitfdata.action" name="zhiding" method="post">
 
     <input type="text" size="66" name="params" id="params"  class="form-control" placeholder="Search for...">
       <select name="sChar" id="sChar" class=" form-control">
	     <option value="*">*</option>
	     <option value="**">**</option>
	     <option value="***">***</option>
	     <option value="****">****</option>
	     <option value="*****">*****</option>
	     </select>   
        
        </form>  <span class="input-group-btn">
      <button class="btn btn-default" type="button" onclick="checkzd()">指定搜索</button>
      </span>
    
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->

</div><!-- /.row --> 
</div>

<div>
<jsp:forward page="testssh.action"></jsp:forward>



</div>
  </body>
</html>
