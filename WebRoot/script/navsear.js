function checksj(){
   var param = document.getElementById("param").value;
  // var params = document.getElementById("params").value;
   if(param == ""  ){
     alert("随机搜索不能为空");
     return false;
   }
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
$(function(){
	var zjxh=1;
	$("#xhid").click(function(){
			zjxh++;
			if(zjxh>19)		zjxh=19;
			$("#sChar").attr("value",zjxh);
			$("#xhid").attr("value",zjxh+"*");
		});
	/*$("#xhid").dblclick(function (){ 
		if(zjxh>1) zjxh=zjxh-3;
		else zjxh=1;
		$("#sChar").attr("value",zjxh);
		//$("#xhid").attr("value",zjxh+"*");
		}); */
		
	});





