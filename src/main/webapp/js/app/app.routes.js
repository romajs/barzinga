angular.module('app.routes', [
	'ui.router'
])
.config(['$urlRouterProvider', function($urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
}])
