var myModule=angular.module("HelloAngl",[]);

myModule.controller("helloAngl",['$scope',function anyname($scope)
{                                 //  ↑ →告诉Angular需要注入 ----↑         
	
	$scope.greeting={text:'hello'};
	
	
}]);