angular.module('itemService', [
])
.service('itemService', function($http, $q, yawp, config) {

    this.endpoint = yawp('/products');

    this.findByCustomLogic = function() {
        return this.endpoint/*.order([{ p: 'name', d: 'asc'}])*/.limit(10).list();
    };

})