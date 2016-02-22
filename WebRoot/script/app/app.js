   var indexapp = angular.module('IndexApp', ["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.controller']);
   indexapp.config(function($stateProvider, $urlRouterProvider) {
      // For any unmatched url, send to /route1
	   $urlRouterProvider.when("", "/showing");
      $urlRouterProvider.otherwise("/#");
      $stateProvider
        //usermanage url
    //前台显示商品
        .state('showing', {
	    url: '/ShowMvIndex',
	    templateUrl: './mtpls/ishowing.html',
	    //template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
	    controller: 'showing'
	})
	.state('showing.descri',{
		//templateUrl: './movies/baseInfo/goodsdescri.html',
	    template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
	    //controller: 'ModalDemoCtrl'
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
	})
/*	 .state('home', {
      url: '/',
      templateUrl: './movies/index.jsp',
      controller: function($scope) {},
      onEnter: function() {
        console.log('home: onEnter()');
      }
    })*/
	/* .state('add-notes', {
      //abstract: true,
      //parent: 'home',
		 url: '/descript',
      onEnter: function($state, $uibModal, $rootScope) {
        var scope = $rootScope.$new();
        scope.note = {
          author: 'Larry',
          text: 'Type your note here.'
        };
        var modal = $uibModal.open({
          templateUrl: './movies/baseInfo/goodsdescri.html',
          size: 'lg',
          resolve:{}
        });
      modal.result.then(function() {
          console.log('note');
          console.log(scope.note);
          // Do something here to save note.
          //$state.go('showing');
        });
      },
    })*/
    
      
    });
var SeatApp=angular.module('SeatApp',['mv.controller']);

   
   