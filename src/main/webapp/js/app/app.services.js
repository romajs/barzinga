var app = angular.module('app.services', []);

/* EX: app.service('newServiceName', function(...) {
 // ...
 }); */

app.service('yawpService', function($http, $q, dxConfig) {

	// FIXME

	return function(url) {

		this.fetch = function() {};

		this.where = function() {};

	};
});

app.factory('dxService', function($http, $q, dxConfig, dxPromise) {

	return function(url) {

		this.promise = dxPromise;

		this.url = function() {
			return dxConfig.apiUrl + '/' + url;
		};
	};

});

function newDxService(name, url, instance, useYawp) {

	console.debug('registering service for creation: ', name, url, instance);

	app.service(name, function(dxConfig, yawpService, dxService) {

		var service = instance;

		if(useYawp) {
			angular.extend(service, new yawpService(url));
		}

		angular.extend(service, new dxService(url));

		console.debug('new dxService \"' + name + '\"" created as: ', service);

		return service;

	});
};

newDxService('itemService', '/items', new ItemService(), true);
// // newDxService('userService', null, new UserService());
