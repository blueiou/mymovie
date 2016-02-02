var app=angular.module('mv.controller',['ui.bootstrap', 'ui.router']);

app.controller('showing',function ($scope,$interval,$http,$log,$uibModal,smvList,goodsList){
		//传入当前的页码到后台
	$scope.currentPage=1;
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
		   $scope.animationsEnabled = true;
			  $scope.open = function(exmaple) {
			    var modalInstance = $uibModal.open({
			      animation: $scope.animationsEnabled,
			      templateUrl: './movies/baseInfo/goodsdescri.html',
			      controller: 'GoodsInstance',
			      size: 'lg',
			      resolve: {
			      exmaple: function() {
			          return exmaple;
			        }
			      }
			    });
			    modalInstance.result.then(function(selectedItem) {
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
	   });
app.controller('GoodsInstance', function($scope, $uibModalInstance, exmaple,goodsList) {
	
	  $scope.exmaple = exmaple;
	  console.log("ID:"+exmaple);
	  goodsList.query({m:"1520",id:exmaple},function(res){
		  console.log(res);
		  $scope.goodDescri=res.goodDescri;
	  });
	  $scope.ok = function () {
		    $uibModalInstance.close($scope.selected.item);
		  };

		  $scope.cancel = function () {
		    $uibModalInstance.dismiss('cancel');
		  };
	  
	});

