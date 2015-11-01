function IndexController($scope, $rootScope, dxConfig) {

	$scope.init = function() {
		$scope.unAuthenticateUser();
		console.debug(dxConfig);
		$scope.googleClientId = dxConfig.settings.googleClientId;
	};

	$scope.unAuthenticateUser = function() {
    	$rootScope.user = {
    		isAuthenticated: false,
    	};
		console.debug("user unathenticated:", $scope.user);
	};

	$rootScope.signOut = function() {
        gapi.auth2.getAuthInstance().signOut().then(function () {
			$scope.unAuthenticateUser();
			$scope.$apply();
		});
	};

	$scope.$on('event:google-plus-signin-success', function (event, authResult) {

		var profile = authResult.getBasicProfile();

    	$rootScope.user = {
    		id:  profile.getId(),
    		name: profile.getName(),
    		imageUrl: profile.getImageUrl(),
    		email:  profile.getEmail(),
    		isAuthenticated: true,
    	};
		console.debug("user athenticated:", $scope.user);

		// The ID token you need to pass to your backend:
    	$rootScope.token = authResult.getAuthResponse().id_token;
		console.debug("user token:", $scope.token);

		$scope.$apply();
	});

	$scope.$on('event:google-plus-signin-failure', function (event, authResult) {
		// TODO
		$scope.unAuthenticateUser();
		$scope.$apply();
	});
	
}