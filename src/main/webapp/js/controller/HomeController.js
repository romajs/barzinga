angular.module('app.home' , [
	'ui.router'
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
.controller('HomeController', function($scope, $rootScope, itemService) {

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

});