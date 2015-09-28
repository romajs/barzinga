function BarzingaController($scope, $rootScope) {

	$scope.items = [];

	$scope.activesFirst = function(item) {
		return item.amount <= 0;
	}

	$scope.init = function() {
		$scope.items = [];
		$scope.items.push({ name: 'Batata Ruffles', code: 'ruffles', amount : 30.0, price: 1.00 });
		$scope.items.push({ name: 'Cafe tres coracoes', code: 'tres', amount : 0.0, price: 1.00 });
		$scope.items.push({ name: 'Pacoquita', code: 'pacoquita', amount : 30.0, price: 0.50 / 3 });
		$scope.items.push({ name: 'Del valle', code: 'del-valle', amount : 10.0, price: 1.00 });
		$scope.items.push({ name: 'Toddynho', code: 'toddynho', amount : 20.0, price: 0.50 });
		$scope.items.push({ name: 'Doritos', code: 'doritos', amount : 30.0, price: 1.00 });
		$scope.items.push({ name: 'Coca-cola', code: 'coca', amount : 20.0, price: 1.50 });
		$scope.items.push({ name: 'Mentos', code: 'mentos', amount : 30.0, price: 1.00 });
		$scope.items.push({ name: 'Twix', code: 'twix', amount : 50.0, price: 0.50 });
	}

	$scope.buy = function(item) {
		if(item.amount > 0) {
			$rootScope.user.balance -= item.price;
			item.amount--;
		}
	}
}