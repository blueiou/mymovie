angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);
angular.module('ui.bootstrap.demo').controller('PaginationDemoCtrl', function ($scope, $log) {
  $scope.totalItems = 64;
  $scope.currentPage = 4;

  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.pageChanged = function() {
    $log.log('Page changed to: ' + $scope.currentPage);
  };

  $scope.maxSize = 5;
  $scope.bigTotalItems = 175;
  $scope.bigCurrentPage = 1;
});
angular.module('ui.bootstrap.demo').controller('ModalDemoCtrl', function($scope, $uibModal, $log) {

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

	});

	// Please note that $modalInstance represents a modal window (instance) dependency.
	// It is not the same as the $uibModal service used above.

	angular.module('ui.bootstrap.demo').controller('ModalInstanceCtrl', function($scope, $uibModalInstance, items) {

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
