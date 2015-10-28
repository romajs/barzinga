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

function newDxService(name, url, instance) {

	console.debug('registering service for creation: ', name, url, instance);

	app.service(name, function(dxConfig, yawpService, dxService) {

		var service = angular.extend({}, new yawpService(url), new dxService(url), instance);
		console.debug('new dxService \"' + name + '\"" created as: ', service);
		return service;

	});
};

newDxService('itemService', '/items', new ItemService());
newDxService('barService', '/bar', {});
newDxService('fooService', '/foo', {});
