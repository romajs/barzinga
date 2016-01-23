angular.module('foodshelf.home' , [
	'ui.router', 'dx.modal'
])
.config(function($stateProvider) {
	$stateProvider.state('home', {
		url: '/',
		controller: 'HomeController',
		templateUrl: 'view/home.html',
		data: {
			requiresLogin: true
		}
	});
})
.controller('HomeController', function($scope, $rootScope, itemService, dxModal) {

	$scope.items = [];

	$scope.activesFirst = function(item) {
		return item.amount <= 0;
	};

	$scope.init = function() {
		$scope.items = itemService.findByCustomLogic();
	}

	$scope.buy = function(item) {

		var messages = [];
		messages.push('Deseja realmente efetuar a compra de \"' + item.name + '\"?');
		messages.push('Valor: R$ ' + item.amount);

		item.amount > 0 && dxModal.confirm(messages, function(result) {
			$rootScope.user.balance -= item.price;
			item.amount--;
		});
	};

});