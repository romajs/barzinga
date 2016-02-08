angular.module('app.history' , [
	'ui.router'
])
.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('history', {
		url: '/history',
		controller: 'appHistoryController',
		templateUrl: 'templates/history.html',
		data: {
			requiresLogin: true
		}
	})
})
.controller('appHistoryController', function($scope, $rootScope, itemService) {

	$scope.history = [
		{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
		{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
		{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
		{ 'date': new Date(), 'description': 'Saldo', 'value': 10.00},
	];

})