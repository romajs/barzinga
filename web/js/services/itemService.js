angular.module('itemService', [
])
.service('itemService', function($http, $q, config) {

    this.findByCustomLogic = function() { // FIXME
        var d = $q.defer();
        // TODO
        var items = [];
        d.resolve(items);
        return d.promise;
    };

})