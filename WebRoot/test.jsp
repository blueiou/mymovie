<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:useBean id="replace" scope="page" class="com.tools.Replace" />
<%
	String par = (String) request.getAttribute("param");
%>
<html>
<head>

<title>DATA</title>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="script/jquery1.8.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript" src="layer.m/layer.m.js"></script>



<script type="text/javascript" src="script/sjdata.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">
tr {
	background: #F9F9F9;
}

tr:nth-child(2n) {
	background: #FFFFFF;
}

tr {
	background-color: expression(( this.sectionRowIndex % 2 == 0)? "#F9F9F9":
		
		 "#FFFFFF");
}

.tdleft {
	text-align: left;
}
</style>

</head>

<body vlink="#0000CC">
	<!-- res nav -->
	<%@include file="check.jsp"%>
	<!-- nav -->

	<div
		style="width: 100%;text-align: center;margin: auto;margin-top: 100px;">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading" style=" font-size:25px ;">随机搜索结果：</div>
		</div>
		<form action="spiltdata.action" method="post">
			<table width="88%" border="0" cellpadding="3" cellspacing="1"
				bgcolor="#666666" id="table1" class="table table-hover">
				<tr>
					<th bgcolor="#f0f0f0">搜索结果</th>
					<th bgcolor="#f0f0f0" style="">操作</th>
					<th bgcolor="#f0f0f0" style=""></th>
				</tr>
				<%
					List list2 = (List) request.getAttribute("dataslist");
					if (list2 == null || 0 == list2.size()) {
				%>
				<tr>
					<td align="center" colspan="3">搜索没有结果</td>
				</tr>
				<%
					} else {

						for (int i = 0; i < list2.size(); i++) {
							Data data = (Data) list2.get(i);
				%>
				<tr bgcolor="FFFFFF" class="center" id="tr<%=data.getId()%>">

					<td width="60%"><input id="da<%=data.getId()%>"
						value="<%=data.getData()%>" type="hidden"><a
						style="a:visited{text-decoration:none;color:#0000CC;}"
						href=spiltdata.action?data= <%=data.getData()%> id="showAll"
						name="showAll"><%=replace.replace(data.getData(), par,
							"<font color='#FF0000'><strong>" + par
									+ "</strong></font>")%></a></td>
					<td width="30%"><input type="button"
						onclick="upda('upd<%=data.getId()%>')" id="upd<%=data.getId()%>"
						class="btn btn-info" value="修改"> &nbsp;&nbsp;
						<button id="<%=data.getId()%>" type="button"
							class="btn btn-danger">删除</button></td>
					<td width="10%"></td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>