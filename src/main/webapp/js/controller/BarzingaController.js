function BarzingaController($scope) {
	
	$scope.user = {
		name: 'Romualdo',
		balance: 10.0
	};

	$scope.items = [];

	$scope.init = function() {
		$scope.items = [];
		$scope.items.push({ name: 'Batata Ruffles', code: 'ruffles', amount : 30.0, price: 1.00 });
		$scope.items.push({ name: 'Coca-cola', code: 'coca', amount : 20.0, price: 1.50 });
		$scope.items.push({ name: 'Twix', code: 'twix', amount : 50.0, price: 0.50 });
	}

	$scope.buy = function(item) {
		item.amount--;
	}
}