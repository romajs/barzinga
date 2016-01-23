angular.module('app.auth.service', [
	'ui.router',
    'directive.g+signin',
])
.service('authService', function($rootScope) {

	var currentUser;
	var token;

	this.login = function(googleAuthResult) {

		var profile = googleAuthResult.getBasicProfile();

		currentUser = {
    		id:  profile.getId(),
    		name: profile.getName(),
    		imageUrl: profile.getImageUrl(),
    		email:  profile.getEmail(),
    	};
		console.debug("user login:", currentUser);

		// The ID token you need to pass to your backend:
    	token = googleAuthResult.getAuthResponse().id_token;
		console.debug("user token:", token);

		$rootScope.$broadcast('authService.login', currentUser);
	}

	this.logout = function() {
        gapi.auth2.getAuthInstance().signOut().then(function () {
			currentUser = undefined;
			console.debug("user logout:", currentUser);
			$rootScope.$broadcast('authService.logout');
		});
	}

	this.isAuthenticated = function()  {
		return typeof currentUser !== 'undefined';
	}

	this.currentUser = function() {
		return currentUser;
	}

})
.run(function($rootScope, $state, authService) {

	$rootScope.$on('event:google-plus-signin-success', function (event, googleAuthResult) {
		$rootScope.$apply();
		authService.login(googleAuthResult);
	});

	$rootScope.$on('event:google-plus-signin-failure', function (event, googleAuthResult) {
		$rootScope.$apply();
		// TODO
	});

})