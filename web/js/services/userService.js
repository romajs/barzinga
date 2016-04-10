angular.module('userService', [
])
.service('userService', function($q) {

	this.getCurrentBalance = function() {
		var d = $q.defer();
		d.resolve(10.50);
		return d.promise;
	}

})