<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" href="css/bootstrap.css" />
  <link rel="stylesheet" href="css/ct-paper.css" />
  <body>
  <div class="container">
  
     <div class="space"></div>
      <div class="main">
        <div class="section section-nude">
        <div class="container tim-container">
                <div id="images">
                     <div class="tim-title">
                        <h2>Images</h2>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-8 col-sm-6 col-md-3">
                            <h4>Rounded Image</h4>
                            <img src="images\movie\2016021815030125.jpg" alt="Rounded Image" class="img-rounded img-responsive">
                            <div class="img-details">
                                <div class="author">
                                    <img src="images\movie\2016021815030125.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                </div>
                            </div>
                   <div class="list-group">
                   <a  class="list-group-item" ui-sref="">我的订单</a>
                   <a  class="list-group-item">我的积分</a>
                   </div>         
                            
                        </div>
                        <div class="col-xs-10  col-sm-9 col-md-8 col-lg-8">
                            <h4>Circle Image</h4><br />
                           <uib-tabset justified="true">
                           <uib-tab hreading="我的订单">订单</uib-tab>
                           <uib-tab hreading="我的团购">团购</uib-tab>
                           </uib-tabset>
                        </div>
                    </div>
                    <div class="row">
                    </div>
                </div>  
                </div> 
                </div> 
                </div> 
                <!--   end images -->
                </div>
            
  </body>
  <script type="text/javascript" src="script/angularjs/angular.js"></script>
   <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
</html>
