angular.module('app.home' , [
	'ui.router', 'dx.modal'
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

.controller('homeController', function($scope, $rootScope, itemService, dxModal) {

	$scope.items = [];

	$scope.activesFirst = function(item) {
		return item !== undefined && item.amount <= 0;
	};

	$scope.init = function() {
		itemService.findByCustomLogic().then(function(items) {
			$scope.items = items;	
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