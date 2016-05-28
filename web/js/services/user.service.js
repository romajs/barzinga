angular.module('userService', [
    //
])
.service('userService', function($q, yawp) {

    angular.extend(this, yawp('/users'));

	this.getCurrentBalance = function() {
		var d = $q.defer();
		d.resolve(10.50);
		return d.promise;
	}

})