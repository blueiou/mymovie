   var myapp = angular.module('PracticeAPP', ["ui.router"])
    myapp.config(function($stateProvider, $urlRouterProvider) {
      // For any unmatched url, send to /route1
      $urlRouterProvider.otherwise("/index")
      $stateProvider
        //usermanage url
    //后台管理人员
        .state('usermanage', {
	    url: '/manageIndex',
	    templateUrl: '/mymovie/tpls/manage/index.html',
	    //template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
	    //controller: 'userManageCtrl'
	})
	.state('usermanage.student', {
	    url: '/students',
	    templateUrl: '/mymovie/tpls/manage/userlist.html',
	    //controller: 'studentlistCtrl'
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
	})
    })