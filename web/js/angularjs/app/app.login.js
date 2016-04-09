angular.module('app.login' , [
	'ui.router', 'app.auth.service', 'app.user.service'
])

.config(function($stateProvider) {
	$stateProvider.state('login', {
		url: '/login',
		controller: 'loginController',
		templateUrl: 'templates/login.html',
		data: {
			requireAuthentication: false
		}
	});
})

// .run(function($rootScope) {
// 	$rootScope.user = undefined;
// })

.controller('loginController', function($rootScope, $state, authService, userService) {

	$rootScope.$on('authService.login', function(event, user) {
		console.log('### user login')
		$rootScope.user = user;
		userService.getCurrentBalance().then(function(value) {
			$rootScope.user.balance = value;
		});
		$state.go('home');
	});

	$rootScope.$on('authService.logout', function() {
		console.log('### user logout')
		$state.go('login');
	});

	$rootScope.logout = function() {
		authService.logout();
	};

	$rootScope.isAuthenticated = function() {
		return authService.isAuthenticated();
	};

})