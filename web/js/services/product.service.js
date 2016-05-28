angular.module('productService', [
    //
])
.service('productService', function(yawp) {

    angular.extend(this, yawp('/products'));

})