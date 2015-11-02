angular.module('app.filters', [

])
// .filter('example', function($filter) {
// 	return function(value, params) {
// 		// ...
// 	};
// })
.filter('dxImg', ['dxResourcesBundle', function(resourcesBundle) {
    return function(input) {
        return input ? resourcesBundle.img[input] : input;
    };
}])