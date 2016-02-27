   var indexapp = angular.module('IndexApp', ["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.filter','mv.controller']);
   indexapp.config(function($stateProvider, $urlRouterProvider) {
      // For any unmatched url, send to /route1
	   $urlRouterProvider.when("", "/userorder");
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
	
	.state('test',{
		url: '/guide/?PracticeId&RequestOfCheckInDay&NumOfGuided&NumOfCheckInDay&NumOfWarned',
	    templateUrl: './movies/seats/test.html',
	    controller:"chooseSeat",
	    resolve:{
	    	msggg:function(){
	    		return "shenm";
	    	}
	    }
	})
	//显示在线选择座位
	.state('bookseat',{
    	  url:'/bookseat/:id/:room/:time/:price',
	templateUrl:'./movies/baseInfo/bookseat.html',
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
var userapp=angular.module('UserApp',["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.filter','mv.controller']);
userapp.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise("/OrderIndex");
	$stateProvider.state('userorder', {
	    url: '/OrderIndex',
	    templateUrl: './mtpls/user/showorder.html',
	    controller: 'searchOrder'
	})
})

   
   