var app=angular.module('mv.controller',[]);

app.controller('showing',function ($scope,$interval,$http,$log,smv){
	    $scope.totalItems = 64;
		$scope.currentPage = 4;
		//传入当前的页码到后台
		   $scope.setPage = function (pageNo) {
		     $scope.currentPage = pageNo;		     
		     console.log("pageNo="+pageNo);
		     var url="smvlist.action?pageno="+pageNo;
			  $http.get(url).success( function(response) {
				  console.log("response"+response.success);			                         		
				   var smvlist = response.smvlist;				                       				                       
			                          $scope.smvlist2=smvlist.stulist;			                           
			                           console.log("smvlist2"+smvlist.stulist);		                          
			                           $scope.bigTotalItems = smvlist.rowcount;                  			                          	  
			  })
		   ;
		     /*
		      * $resource 传到后台
		      * console.log(smv.retrievePerson($scope.currentPage));*/
		   };

		  /* $scope.pageChanged = function() {
			   
		     $log.log('Page changed to: ' + $scope.currentPage);
		   };*/
		   $http.get("smvlist.action").success( function(response) {
				  console.log(response);			                         		
				   var smvlist = response.smvlist;				                       				                       
			                          $scope.smvlist2=smvlist.stulist;			                           
			                           console.log("smvlist2"+smvlist.stulist);		                          
			                           $scope.bigTotalItems = smvlist.rowcount;                  			                          	  
			  });
		   $scope.maxSize = 5;
		  // $scope.bigTotalItems = 175;
		   $scope.bigCurrentPage = 1;
	   });
	app.controller('prepara',function ($scope,$http){		   
		   var url="pmvlist.action";
		   $http.get(url).success( function(response) {
		                           $scope.pmvlist = response; 
		                        }); 
		   
	   });