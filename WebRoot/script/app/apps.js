   var indexapp = angular.module('IndexApp', ["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.controller']);
   indexapp.config(function($stateProvider, $urlRouterProvider) {
      // For any unmatched url, send to /route1
      $urlRouterProvider.otherwise("/index");
      $stateProvider
        //usermanage url
    //后台管理人员
        .state('showing', {
	    url: '/ShowMvIndex',
	    templateUrl: './mtpls/ishowing.html',
	    //template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
	    controller: 'showing'
	})
	.state('preparatory', {
	    url: '/PreMvIndex',
	    templateUrl: './mtpls/prepara.html',
	    controller: 'prepara'
	})
    .state('usermanage.teacher', {
        url: '/teachers',
        templateUrl: '/mymovie/tpls/manage/teacherlist.html',
        //controller: 'teacherlistCtrl'
    })
    .state('usermanage.batch', {
        url: '/batchadd',
        templateUrl: '/mymovie/tpls/manage/batchadd.html',
       // controller: 'batchaddCtrl'
    })
     //--------------teacherIndex
	.state('teacher', {
	    url: '/teacher/index',
	    templateUrl: '/mymovie/tpls/tmpls/teacher/index.html',
	   // controller: 'teacherIndexCtrl'
	})
	.state('teacher.guide', {
	    url: 'teacher/guide',
	    templateUrl: '/mymovie/tpls/tmpls/teacher/guide.html',
	   //controller: 'teacherGuideCtrl'
	})
	.state('teacher.viewstu', {
	    url: '/guide/?PracticeId&RequestOfCheckInDay&NumOfGuided&NumOfCheckInDay&NumOfWarned',
	    templateUrl: '/mymovie/tpls/tmpls/teacher/viewStuRecord.html',
	   // controller: 'viewStuRecordCtrl'
	});
    });
  /* indexapp.controller('showing',function ($scope,$http,$log){
  $scope.totalItems = 64;
	   $scope.currentPage = 4;

	   $scope.setPage = function (pageNo) {
	     $scope.currentPage = pageNo;
	   };

	   $scope.pageChanged = function() {
	     $log.log('Page changed to: ' + $scope.currentPage);
	   };

	   $scope.maxSize = 5;
	   $scope.bigTotalItems = 175;
	   $scope.bigCurrentPage = 1;
	   var url="smvlist.action";
	  $http.get(url).success( function(response) {
	                           $scope.smvlist = response; 
	                          console.log(JSON.stringify(response));
	                        
	   
   
   
   });
   });
  indexapp.controller('prepara',function ($scope,$http){
	   
	   var url="pmvlist.action";
	   $http.get(url).success( function(response) {
	                           $scope.pmvlist = response; 
	                        }); 
	   
   });*/
   
   