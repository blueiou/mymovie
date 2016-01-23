<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

 
<!-- <script type="text/javascript" src="script/jquery1.8.js"></script>
 <script type="text/javascript" src="layer/layer.js"></script> 
 <script type="text/javascript" src="layer.m/layer.m.js"></script> -->
<script type="text/javascript" src="script/navsear.js"></script>
 <link href="css/bootstrap.css" rel="stylesheet">
 
 <div data-role="page"><!-- </div 已放到原始数据处 -->
 <div data-role="header">
    <a href="datapage.action" data-role="button" data-icon="home">首页</a>
    <h1>搜索数据</h1>
  </div>
  <nav class="navbar navbar-default">
<div class="navbar-form navbar-left" role="search"><!-- 2search -->
  <form name="suiji"  action="datalist.action" method="post" onsubmit = "return checksj();">
  
   <div class="form-group">
       <input type="text" size="66" name="param" id="param" class="form-control" placeholder="Search for...">
  </div>
  <button type="button"  onclick="checksj()" class="btn btn-default">随机搜索</button>
</form>
 
  <form action="specitfdata.action" name="zhiding" method="post">
  <div class="form-group">
    <input type="text" size="66" name="params" id="params"  class="form-control" placeholder="Search for...">
  </div>
  <input type="hidden" value="1" id="sChar" name="sChar"/>
  <input type="button" class="" id="xhid" value="1*"/>
  
  <span id="zdspan"></span>
  <button type="button" class="btn btn-default" onclick="checkzd()">指定搜索</button>
</form>
  </div>
   <% 
      String uname=(String)session.getAttribute("user");
            		//out.print(uname);
      if(session.getAttribute("user")==null) response.sendRedirect("ulogin.jsp");
      else{   %>
<p class="navbar-text navbar-right"><%=uname %>，欢迎您 &nbsp;&nbsp;&nbsp;</p>
<%} %>
</nav>



