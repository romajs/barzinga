angular.module('app.login' , [
	'ui.router'
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

	$rootScope.user = {
		isAuthenticated: false,
	};

})
.run(function($rootScope, $state) {

	$rootScope.$on('event:google-plus-signin-success', function (event, googleAuthResult) {

		var profile = googleAuthResult.getBasicProfile();

    	$rootScope.user = {
    		id:  profile.getId(),
    		name: profile.getName(),
    		imageUrl: profile.getImageUrl(),
    		email:  profile.getEmail(),
    		isAuthenticated: true,
    	};
		console.debug("user athenticated:", $rootScope.user);

		// The ID token you need to pass to your backend:
    	$rootScope.token = googleAuthResult.getAuthResponse().id_token;
		console.debug("user token:", $rootScope.token);

		$rootScope.$apply();

		$state.go('home');
	});

})
.run(function($rootScope, $state) {

	$rootScope.$on('event:google-plus-signin-failure', function (event, googleAuthResult) {
		// TODO
		$rootScope.$apply();
	});

})
.controller('LoginController', function($rootScope, $state) {

	$rootScope.signOut = function() {
        gapi.auth2.getAuthInstance().signOut().then(function () {

	    	$rootScope.user = {
	    		isAuthenticated: false,
	    	};
			console.debug("user unathenticated:", $rootScope.user);

			$rootScope.$apply();

			$state.go('login');
		});
	};

});