<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>全部原始数据</title>
   <script type="text/javascript" src="script/jquery1.8.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="layer.m/layer.m.js"></script>
	<script type="text/javascript" src="script/sjdata.js"></script>
<%--  <link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css">
    <script src="script/jquery.mobile-1.3.2.min.js"></script>  --%>
	<link href="css/bootstrap.css" rel="stylesheet">
	
	<script type="text/javascript">
	$(document).ready(function(){
	$("#choseall").click(function(){
		
		if(this.checked){
			
			$("input[name='checkbox']").attr("checked","checked");
		}
		else $("input[name='checkbox']").removeAttr("checked");
	});
	$("#delall").click(function(){
		/* var alldata={'info':[]};
		$("input[name='checkbox']:checked").each(function(i,n){
			alldata['info'].push(n.value);
		}); */
		//alert(alldata);
		 $.ajax({
			url:"servlet/DelServlet",
			type:"post",
			data:$("#form1").serialize(),
			error:function(requset){
				alert("删除失败");
			},
			success:function(results){
				results=eval("("+results+")");
			}
		}); 
		
		//$("#form1").submit();
	});	
	})
	
	</script>
  </head>
  <body>
  <!-- nav -->
<div>
	asas<div id="result">saaaa</div>
</div>
  <!-- nav -->
  <!-- add data -->
 <!--  <div data-role="content">
 
  
  </div> -->
   <!-- /add data -->
<%--  <button   onclick="window.open('addData.jsp')"><span class="glyphicon glyphicon-plus"></span>添加数据</button>
   
   
    <div style="width: 100%;text-align: center;margin: auto;margin-top: ;"> --%>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading" style=" font-size:25px ;">全部原始数据</div>
</div>
<form action="servlet/DelServlet" method="post" id="form1">
  <table width="88%" border="0" cellpadding="3" cellspacing="1" bgcolor="#666666" id="table1" class="table table-hover">
<tr>

	<td colspan="2"><input type="button" name="deleall" id="delall" value="删除" class="btn btn-defautl"/></td>
<td ><input type="checkbox" name="choseall" id="choseall" value="" class="btn btn-defautl"/>全选/全不选</td>
</tr>
<tr>
<th bgcolor="#f0f0f0" >搜索结果</th>
  <th bgcolor="#f0f0f0" style="" colspan="2">操作</th>
  <th bgcolor="#f0f0f0" style=""></th>
</tr>
<s:iterator value="page.stulist"  var="s">
<tr bgcolor="FFFFFF" class="center" id="tr${s.id}">
    <td width="60%"><input id="da${s.id}" value="${s.data}"  type="hidden"><a class="navbar-link" href="spiltdata.action?data=${s.data}" id="showAll" name="showAll"> ${s.data}</a></td>
     <td width="30%"><input  type="button" onclick="upda('upd${s.id}')" id="upd${s.id}" class="btn btn-info" value="修改"> &nbsp;&nbsp;<button id="${s.id}" type="button" class="btn btn-danger">删除</button>
</td>
<td width="10%"><input type="checkbox" name="checkbox" value="${s.id}"  />${s.id}</td>
       </tr>
</s:iterator>
</table>
</form>
 总共有${page.rowcount}条记录
总共有${page.pagecount }页
当前${page.pageno }/${page.pagecount }页<br>

${page.sb2}

 <br>
</div>

 </div>
 <!--  <div data-role="footer">
  <h1>页脚文本</h1>
  </div> -->

  </body>
</html>
