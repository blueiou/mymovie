var app=angular.module('mv.controller',[]);

app.controller('showing',function ($scope,$interval,$http,$log,smv){
	 /* $scope.totalItems = 64;
		   $scope.currentPage = 4;

		   $scope.setPage = function (pageNo) {
		     $scope.currentPage = pageNo;
		   };

		   $scope.pageChanged = function() {
		     $log.log('Page changed to: ' + $scope.currentPage);
		   };

		   $scope.maxSize = 5;
		   $scope.bigTotalItems = 175;*/
		  // $scope.bigCurrentPage = 1;
	 console.log("enter1:");
	 var list=smv.retrievePerson();
	 console.log(list);
	 $scope.myclick=function(){
			   
			   console.log("enter2:");
			   //console.log(smv.retrievePerson());
		   };
	/*	   var url="smvlist.action";
		  $http.get(url).success( function(response) {
			  var userinfo=[];
		                           $scope.smvlist = response; 
		                          console.log(response);
		                          var objs =response;
		                          
		                          var b=objs.smvlist;

		                          //$scope.bigCurrentPage = b.pageno;
		                        
		                          //console.log(objs.smvlist.pagecount);
		                       
		                          
	   });*/
	   });
	app.controller('prepara',function ($scope,$http){
		   
		   var url="pmvlist.action";
		   $http.get(url).success( function(response) {
		                           $scope.pmvlist = response; 
		                        }); 
		   
	   });