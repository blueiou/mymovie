<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testpaging.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link href="" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
  </head>
  
  <body ng-app="ui.bootstrap.demo">
    This is my JSP page. <br>
    <div ng-controller="PaginationDemoCtrl">
    

    <hr />
    <h4>Limit the maximum visible buttons</h4>
    <h6><code>rotate</code> defaulted to <code>true</code>:</h6>
    <uib-pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" num-pages="numPages"></uib-pagination>
    
    <h6><code>boundary-link-numbers</code> set to <code>true</code> and <code>rotate</code> set to <code>false</code>:</h6>
    <uib-pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false"></uib-pagination>
    <pre>Page: {{bigCurrentPage}} / {{numPages}}</pre>
<hr>
<div ng-controller="ModalDemoCtrl">
 <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
            <h3 class="modal-title">I'm a modal!</h3>
        </div>
        <div class="modal-body">
            <ul>
                <li ng-repeat="item in items">
                    <a href="#" ng-click="$event.preventDefault(); selected.item = item">{{ item }}</a>
                </li>
            </ul>
            Selected: <b>{{ selected.item }}</b>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
            <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
        </div>
    </script>
    <button type="button" class="btn btn-default" ng-click="open()">Open me!</button>
    <button type="button" class="btn btn-default" ng-click="open('lg')">Large modal</button>
    <button type="button" class="btn btn-default" ng-click="open('sm')">Small modal</button>
</div></div>
<hr />


<div ng-controller="MainCtrl">
<ui-view></ui-view>

  <script type="text/ng-template" id="/home.tpl.html">
    <p>Hello {{name}}!</p>
    <div id="btn-bar">
      <button id="btn-add-note" ui-sref="add-note.edit">Add Note</button>
      <p> {{ state.current.name }} </p>
    </div>
  </script>

  <script type="text/ng-template" id="/edit.tpl.html">
    <h2>Edit</h2>
    <form name="edit-form">
      <label>
        Author:
        <input name="author" ng-model="note.author" type="text">
      </label>
      <label>
        Note:
        <textarea name="note" ng-model="note.text" rows="3" cols="50"></textarea>
      </label>
      <div>
        <button ui-sref="add-note.preview">Preview</button>
      </div>
    </form>
  </script>


</div>



  </body>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-animate.js"></script>
 <!--  <script src="./script/angularjs/angular.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script> -->
  <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <script src="./script/exmaple.js"></script>
  <script src="./script/app/apps.js"></script>
  <script src="./script/app/controller.js"></script>
  
</html>
