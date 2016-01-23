angular.module('foodshelf.login' , [
	'ui.router', 'auth.service', 'user.service'
])
.config(function($stateProvider) {
	$stateProvider.state('login', {
		url: '/login',
		controller: 'LoginController',
		templateUrl: 'view/login.html',
		data: {
			requiresLogin: false
		}
	});
})
.run(function($rootScope) {
	$rootScope.user = undefined;
})
.controller('LoginController', function($rootScope, $state, authService, userService) {

	$rootScope.$on('authService.login', function(event, user) {
		$rootScope.user = user;
		userService.getCurrentBalance().then(function(value) {
			$rootScope.user.balance = value;
		});
		$state.go('home');
	});

	$rootScope.$on('authService.logout', function() {
		$state.go('login');
	});

	$rootScope.logout = function() {
		authService.logout();
	};

	$rootScope.isAuthenticated = function() {
		return authService.isAuthenticated();
	};

});