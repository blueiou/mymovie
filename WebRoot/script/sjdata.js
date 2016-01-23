/*function checkxg(){
	   document.suiji.submit();
	  return true;
	}*/
 //异步删除
 $(document).ready(function(){ 
		 $("button").click(function(){ 
		 delid = $(this).attr("id"); 
		 var flag=false;
		 if(delid!=null){
				flag=true;
					}
		if(!flag){
						return false;
					}else{
					if(confirm("确定要删除么？")){
						 $.ajax({
							 type: "post", 
							 url: "deldata.action", 
							 dataType: "html",  
							 data: "did="+delid, 
							 success: function(result){ 
							 var res = String($.trim(result)); 
							 
							 if(res=="true"){
								 
								 $("#tr"+delid).slideToggle();
						         	//alert("ture"); 
							 }else { 
					         	alert("删除失败");
							 }
							 } 
							 }); 
					}
		 }
		 });  
	 }); 
 //修改数据
	   function upda(obj){
		   var updid=""+obj;
		   var updid2=updid.substring(3);
		   var updata=$("#da"+updid2).val();
		   layer.open({
			    type: 1,
			    content: "<div class='alert alert-info' role='alert'>修改数据"
			    +"</div><form name='xgdata'  action='updatas.action' method='post' ><input type='text' value="+updata+" id='textid' class='form-control' ></form><div class='container'><button class='btn btn-success' id='saved' onclick='upSubmit("+updid2+")'><span class='glyphicon glyphicon-save'></span>&nbsp;&nbsp;保存修改</button></div>",
			    style: "width:100%; height:"+ document.documentElement.clientHeight +"px; background-color:#F2F2F2; border:none;"
		   });
 }
	   function upSubmit(did){
		   var datas=$("#textid").val();
		   //alert(datas+"; id:"+did);
		   $.ajax({
				 type: "post", 
				 url: "upddata.action", 
				 dataType: "html",  
				 data: "did="+did+"&datasString="+datas, 
				 success: function(result){ 
				 var res = String($.trim(result)); 
				 if(res=="true"){
					// alert("保存修改成功");
					/* layer.open({
						    content: "保存修改成功",
						    style: "background-color:#09C1FF; color:#fff; border:none;",
						    time: 1
						
						});*/
					 layer.msg("保存修改成功");
					 
					// layer.closeAll();
				 }else  alert("保存修改失败,请检查修改数据");
				 
				 } 
				 });    
	   }