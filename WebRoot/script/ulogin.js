 
  function loadpage(){
	  layer.open({
		    type: 1,
		    content: "<div class='alert alert-info' role='alert'>Sign in"
		    +"</div><form name='login'  action='ulogin.action' method='post' onsubmit='return checkulogin()'>"
		    +"<input type='text' value='' id='uname' name='uname' onchange='checkname()' class='form-control' >"
		    +"<span id='spuser'></span><br><br><input type='password' name='upass' onchange='' id='upass' onchange='' class='form-control' >"
		    +"<span id='sppass'></span></form><br><div class='container'><button class='btn btn-success' id='signin' onclick='loginSubmit()'>"
		    +"<span class='glyphicon glyphicon-ok'></span>&nbsp;登陆</button></div>",
		    style: "width:100%; height:"+ document.documentElement.clientHeight +"px; background-color:#F2F2F2; border:none;"
	   });  
 } 
  
  $(document).ready(function(){
	  loadpage();
		  //验证用户名
	 }); 
  function checkname(){
	  var username = $("#uname").val();
	  if (username.match( /^[a-zA-Z0-9_]{3,20}$/)) {
		  //document.login.submit();
		  $("#spuser").html(" ");
		 return true;
	  }
	  else {
		  $("#spuser").html("<font color='#FF0000'>*用户名只能是字母、数字和下划线，请重新输入</font>");  
		//  layer.msg("用户名只能是字母、数字和下划线，请重新输入");
		  return false;
	  }
  }
  function loginSubmit(){
		var uname=$("#uname").val();
		var upass=$("#upass").val();
		$.ajax({
			 type: "post", 
			 url: "clogin.action", 
			 dataType: "html",  
			 data: "uname="+uname+"&upass="+upass, 
			 success: function(result){ 
			 var res = String($.trim(result)); 
			 if(res=="true"){
				 
				 $("#spuser").html("");
				 document.login.submit();
				 return true;
			 }
			 else if(res=="false"){ 
				 $("#spuser").html("<font color='#FF0000'>*用户名或密码错误</font>");
				 return false;
			 }
			 } 
			 }); 
		 
	
		return false;
	}
  
  function checkulogin() {
	if(checkname()&&loginSubmit()) {
		return true;
	}
	else return false;
}