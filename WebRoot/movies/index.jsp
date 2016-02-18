<%@ page language="java" import="java.util.* ,com.tools.* " pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>电影首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="css/ct-paper.css" />
<% String time=new MyDate().getYMD(); %>
当前时间：<%=time %>
  </head>
  <style type="text/css">
  form.tab-form-demo .tab-pane {
    margin: 10px 10px;
  }
</style>
  <body ng-app="IndexApp" >
  
  <div class="container">
         <div id="navbar">
                            <nav class="navbar navbar-default">
                              <div class="container-fluid">
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                  </button>
                                  <a class="navbar-brand" ui-sref="showing" >Menu</a>
                                </div>
                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                  <ul class="nav navbar-nav">
                                    <li class="active"><a href="#">Link</a></li>
                                    <li><a href="#">Link</a></li>
                                    <li class="dropdown">
                                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
<!--                                  You can add classes for different colours on the next element -->
                                      <ul class="dropdown-menu dropdown-menu-right">
                                        <li class="dropdown-header">Dropdown header</li>
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">One more separated link</a></li>
                                      </ul>
                                    </li>
                                  </ul>
                                </div><!-- /.navbar-collapse -->
                              </div><!-- /.container-fluid -->
                            </nav>
                        
                        </div><!--  end navbar -->
<uib-tabset justified="true">
    <uib-tab heading="正在热映" >
    <div ng-controller="showing">
     <div style="margin-top: 45px;" >
         <!-- 单层获取值 -->          
   <div ng-repeat="s in smvlist.stulist">
            <div class="col-md-4 portfolio-item">
             <a href="">
                    <img class="img-responsive" src="{{s.playbillurl}}"  ng-click="open(s.good_id)">
               </a>
                <h3>
                    <a href="" ng-model="exmaple" ng-click="open(s.good_id)" >{{s.sysname}}</a>
                    
                   <!--  <a href="" ng-click="open('lg')" >{{s.baseInfo.base_id}}</a> -->
                </h3>
               <!--  <p ng-model="exmaple" ng-click="open(s.baseInfo.base_id)">点击了解更多</p> -->
            </div>
   </div> 
           </div> 
           <center>
         <uib-pagination ng-click="setPage(bigCurrentPage)" total-items="smvlist.pagecount*10" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false" num-pages="numPages"></uib-pagination>
    <pre>Page: {{bigCurrentPage}} / {{numPages}}</pre> 
    </center>  
     </div>       
    </uib-tab>
    
    <uib-tab heading="预备上映" >
    <div ng-controller="prepara">
    <div  style="margin-top: 45px;"> 
     <div ng-repeat="p in pmvlist.stulist" >
            <div class="col-md-4 portfolio-item">
                <a href="#">
                    <img class="img-responsive" src="" alt="">
                </a>
                <h3>
                    <a href="#">{{p.sysname}}</a>
                    
                </h3>
                <!-- <p>{{p.showtime}}</p> -->
            </div>
   </div>  </div> 
   <uib-pagination ng-click="setPage(bigCurrentPage)" total-items="smvlist.pagecount*10" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false" num-pages="numPages"></uib-pagination>
    <pre>Page: {{bigCurrentPage}} / {{numPages}}</pre> 
   </div> 
    </uib-tab>
    <uib-tab heading="放映时刻表" >
    <div ng-controller="playtime" >
    <div ng-repeat="s in list">
    <a href=""> {{s.goods.sysname}}</a>
    <a href=""> {{s.play_time}}</a>
    </div>
    </div>
    </uib-tab>
  </uib-tabset>
</div>
  <center>

    
   </center>      
            </div>
          
<hr />
        </div>
        
        <hr />
  
<input type="text" value="" id="clock" />
    <script>
   function clock() {
	   document.getElementById("clock").value = new Date().toLocaleString();
   }
   //setInterval("clock()",1000);
   //var int=self.setInterval("clock()",1000);
    </script>
  </body>
  <!-- Angular -->
  <script src="./script/angularjs/angular.js"></script>
  <script src="./script/angularjs/angular-resource.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script>
   <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <!-- UI-Router -->
  <script src="./script/angularjs/angular-ui-router.js"></script>
  <!-- App Script -->
    <script src="./script/app/apps.js"></script>
    <script src="./script/app/service.js"></script>
    <script src="./script/app/controller.js"></script>
    <!-- other -->
    
</html>
