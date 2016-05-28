angular.module('home' , [
	'ui.router',
	'dx.modal'
])

.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('home', {
		url: '/home',
		controller: 'homeController',
		templateUrl: 'templates/home.html',
		data: {
			requireAuthentication: true
		}
	})
})

.controller('homeController', function($scope, $rootScope, productService, dxModal) {

	$scope.products = [];

	$scope.activesFirst = function(product) { // FIXME
		return product !== undefined && product.quantity <= 0;
	};

	$scope.init = function() {
		productService.list().then(function(products) {
			$scope.products = products;	
		});
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

})