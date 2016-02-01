var app=angular.module('mv.controller',['ui.bootstrap', 'ui.router']);

app.controller('showing',function ($scope,$interval,$http,$log,$uibModal,smvList,goodsList){
		//传入当前的页码到后台
	$scope.currentPage=1;
		 /*  $scope.setPage = function (pageNo) {
		     $scope.currentPage = pageNo;		     
		     console.log("pageNo="+pageNo);
		     var url="smvlist.action?pageno="+pageNo;
			  $http.get(url).success( function(response) {
				  $scope.smvlist = response.smvlist;				                       				                       
			  })
		   ;
		     
		      * $resource 传到后台
		      * console.log(smv.retrievePerson($scope.currentPage));
		   };*/
		   //在还没触发setPage()函数时候pageno=1
		 /* $http.get("smvlist.action").success( function(response) {
				  console.log(response);			                         		
				  $scope.smvlist = response.smvlist;				                       				                       
			                        //因为其是按照每页十条记录显示的，所以先取出总页数 再*10得到bigTotalItems
			  });*/
	     // var pageNo=$scope.currentPage;

		   $scope.search = function (){
			   goodsList.query({pageno:$scope.currentPage,m:"1510"},function(res){
			   $scope.smvlist=res.smvlist;
			   $scope.goodsDecri=$scope.smvlist.stulist;
			   
			   console.log("$scope.goodsDecri.baseInfo");
		   });
		   };
		   $scope.setPage = function (pageNo) {
			    $scope.currentPage = pageNo;		     
			   $scope.search();			   
				   };
		   $scope.search();
//详情
			  $scope.items = ['item1', 'item2', 'item3', 'item4', 'item5', 'item6', 'item7', 'item8', 'item9', 'item10', 'item11', 'item12', 'item13'];
			  $scope.animationsEnabled = true;
			  $scope.open = function(size) {
			    var modalInstance = $uibModal.open({
			      animation: $scope.animationsEnabled,
			      templateUrl: './movies/goodsdescri.html',
			      controller: 'ModalInstanceCtrl',
			      size: size,
			      resolve: {
			        items: function() {
			          return $scope.items;
			        }
			      }
			    });

			    modalInstance.result.then(function(selectedItem) {
			      $scope.selected = selectedItem;
			    }, function() {
			      $log.info('Modal dismissed at: ' + new Date());
			    });
			  };

			  $scope.toggleAnimation = function() {
			    $scope.animationsEnabled = !$scope.animationsEnabled;
			  };


});






	app.controller('prepara',function ($scope,$interval,$http,goodsList){	
		$scope.search = function (){
			goodsList.query({pageno:$scope.currentPage,m:"1511"},function(res){
				   $scope.pmvlist=res.pmvlist;
				   console.log(res);
			   });
			   };
		$scope.setPage = function (pageNo) {
				    $scope.currentPage = pageNo;		     
				   $scope.search();			   
					   };
			   $scope.search();
		
		
		
		
		
	/*	采用$ http
	 *    $scope.setPage=function(pageNo){
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
			   $scope.bigCurrentPage = 1;*/
	   });
	
	/*app.controller('ModalDemoCtrl', function($scope, $uibModal, $log) {

		  $scope.items = ['item1', 'item2', 'item3', 'item4', 'item5', 'item6', 'item7', 'item8', 'item9', 'item10', 'item11', 'item12', 'item13'];

		  $scope.animationsEnabled = true;

		  $scope.open = function(size) {

		    var modalInstance = $uibModal.open({
		      animation: $scope.animationsEnabled,
		      templateUrl: 'test.html',
		      controller: 'ModalInstanceCtrl',
		      size: size,
		      resolve: {
		        items: function() {
		          return $scope.items;
		        }
		      }
		    });

		    modalInstance.result.then(function(selectedItem) {
		      $scope.selected = selectedItem;
		    }, function() {
		      $log.info('Modal dismissed at: ' + new Date());
		    });
		  };

		  $scope.toggleAnimation = function() {
		    $scope.animationsEnabled = !$scope.animationsEnabled;
		  };
		});*/
	
app.controller('ModalInstanceCtrl', function($scope, $uibModalInstance, items) {

	  $scope.items = items;
	  $scope.selected = {
	    item: $scope.items[0]
	  };

	  $scope.ok = function() {
	    $uibModalInstance.close($scope.selected.item);
	  };

	  $scope.cancel = function() {
	    $uibModalInstance.dismiss('cancel');
	  };
	});
	
