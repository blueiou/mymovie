var app=angular.module('mv.controller',[]);

app.controller('showing',function ($scope,$interval,$http,$log,smv){
	    //$scope.totalItems = 64;
	 $scope.currentPage = 1;
	 $scope.maxSize =2;
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
			                          // $scope.bigTotalItems = smvlist.rowcount;                  			                          	  
			  })
		   ;
		     /*
		      * $resource 传到后台
		      * console.log(smv.retrievePerson($scope.currentPage));*/
		   };

		  /* $scope.pageChanged = function() {
			   
		     $log.log('Page changed to: ' + $scope.currentPage);
		   };*/
		   //在还没触发setPage()函数时候pageno=1
		   $http.get("smvlist.action").success( function(response) {
				  console.log(response);			                         		
				   var smvlist = response.smvlist;				                       				                       
			                          $scope.smvlist2=smvlist.stulist;			                           
			                           console.log("smvlist2"+smvlist.stulist);		                          
			                        /*因为其是按照每页十条记录显示的，所以先取出总页数 再*10得到bigTotalItems
			                           
			                           */
			                          
			                           $scope.bigTotalItems = smvlist.pagecount*10;
			  });
		   $scope.bigCurrentPage = 1;
	   });
	app.controller('prepara',function ($scope,$interval,$http){		   
		   $scope.setPage=function(pageNo){
			   $scope.currentPage=pageNo;
			   console.log("pageNo="+pageNo);
			     var url="pmvlist.action?pageno="+pageNo;
				  $http.get(url).success( function(response) {
					  console.log("response"+response.success);			                         		
					   var pmvlist = response.pmvlist;				                       				                       
				                          $scope.pmvlist2=pmvlist.stulist;			                           
				                           console.log("pmvlist.rowcount"+pmvlist.rowcount);		                          
				                           $scope.bigTotalItems = pmvlist.rowcount; 
				  });
		   };
		   $http.get("pmvlist.action").success( function(response) {
		                           var pmvlist = response.pmvlist;
		                           $scope.pmvlist2=pmvlist.stulist;
		                           $scope.bigTotalItems = pmvlist.rowcount; 
		                        }).error(function(){
		                        	console.log("请求错误");
		                        });
			   $scope.bigCurrentPage = 1;
	   });