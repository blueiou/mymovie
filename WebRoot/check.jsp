<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



 <nav class="navbar navbar-default">
<div class="navbar-form navbar-left" role="search"><!-- 2search -->
  </div>
   <% 
      String uname=(String)session.getAttribute("user");
      if(session.getAttribute("user")==null) response.sendRedirect("ulogin.jsp");
      else{   %>
<p class="navbar-text navbar-right"><%=uname %>，欢迎您 &nbsp;&nbsp;&nbsp;</p>
<%} %>
</nav>