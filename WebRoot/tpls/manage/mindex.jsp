<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>主页 - 学生外出实习安全管理系统</title>
  <link rel="stylesheet" href="" />
  </head>
 <body ng-app="PracticeAPP">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    
                </button>
                <a class="navbar-brand" href="/">实习管理系统<img src="" /></a>
            </div>
         
                  
                    <li><a ui-sref="practice" ><i class="fa fa-tasks fa-stack-1x"></i><br />实习管理</a></li>
                    <li><a ui-sref="supervise" ><i class="fa fa-sitemap fa-stack-1x"></i><br />协同管理</a></li>
                    <li><a href="#"><i class="fa fa-list-alt fa-stack-1x"></i><br />报表管理</a></li>
              
        </div>
    </div>
     <a ui-sref="usermanage"><br />用户管理</a>
<div ui-view></div>


<!-- Angular -->
  <script src="../../script/angularjs/angular.js"></script>
  <!-- UI-Router -->
  <script src="../../script/angularjs/angular-ui-router.js"></script>
  <!-- App Script -->
    <script src="../../script/app/app.js"></script>
  </body>
  <script type="text/javascript">
  //var a=
  </script>
</html>

