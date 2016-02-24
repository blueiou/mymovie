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
	
	.state('test',{
		url: '/guide/?PracticeId&RequestOfCheckInDay&NumOfGuided&NumOfCheckInDay&NumOfWarned',
	    templateUrl: './movies/seats/test.html',
	    controller:"chooseSeat",
	    resolve:{
	    	msggg:function(){
	    		return "shenm ";
	    	}
	    }
	})
	//显示在线选择座位
	.state('bookseat',{
    	  url:'/bookseat/:id/:room/:time',
	templateUrl:'./movies/seats/test.html',
	controller:"chooseSeat",
	/*resolve:{
		basedata:"tmList",
		showseat:function($http,$stateParams){
			return $http.get("tm.action?play_id="+$stateParams.id+"&m=1710").then(function(items) {
				console.log(items);
				return items;
			  });
			return $http.get("tm.action?play_id="+$stateParams.id+"&m=1710").$promise.then(function(result){
				console.log(result);
				return result;
			});
			return basedata.query({
                play_id:$stateParams.id
                }).$promise.then(function (response) {
                           return response;
                       });
		}
	
	}*/
	
      });
   });
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
    
      
  
/*var SeatApp=angular.module('SeatApp',['mv.controller']);*/

   
   