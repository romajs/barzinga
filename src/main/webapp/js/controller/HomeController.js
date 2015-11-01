function HomeController($scope, $rootScope, itemService) {

	$scope.items = [];

	$scope.activesFirst = function(item) {
		return item.amount <= 0;
	}

	$scope.init = function() {
		$scope.items = itemService.findByCustomLogic();
	}

	$scope.buy = function(item) {
		if(item.amount > 0) {
			$rootScope.user.balance -= item.price;
			item.amount--;
		}
	}
}