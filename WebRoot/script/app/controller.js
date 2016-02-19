var app=angular.module('mv.controller',['ui.bootstrap', 'ui.router']);

app.controller('showing',function ($scope,$interval,$http,$log,$uibModal,goodsList){
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
			   
			   console.log(res);
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
			    modalInstance.result.then(function() {
			    }, function() {
			    	//$scope.search();
			      console.log("打印：");
			      //console.log(d);
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
			   });
			   };
			   //分页
		$scope.setPage = function (pageNo) {
				    $scope.currentPage = pageNo;		     
				   $scope.search();			   
					   };
			   $scope.search();
	   });
//商品详情页
app.controller('GoodsInstance', function($scope, $uibModalInstance, exmaple,goodsList,usersListG) {
var time=new Date();
	$scope.time=time;
	console.log("输出的时间"+time);
	  $scope.exmaple = exmaple;
	  console.log("商品ID:"+exmaple);
	 goodsList.query({m:"1520",id:exmaple},function(res){
		 // goodsList.query({m:"1520"},function(res){
		  console.log(res);
		  $scope.goodDescri=res.goodDescri;
	  });
	 //获取用户评价
	 usersListG.query({m:"10186",mid:exmaple},function(res){
 $scope.userissue=res.reply;
 console.log(res);
	 });
	  $scope.ok = function () {
		    $uibModalInstance.close($scope.selected.item);
		  };
		  $scope.cancel = function () {
		    $uibModalInstance.dismiss('cancel');
		  };
	});
//放映时刻表
app.controller('playtime',function($scope,$interval,$http,goodsList){
	var time=new Date();
	console.log(time);
	$scope.search=function(){
		goodsList.query({m:"1525",playTime:time},function(res){
			console.log(res);
			$scope.list=res.reply;
		});
	};
	$scope.search();
});


