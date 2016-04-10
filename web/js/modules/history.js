angular.module('history' , [
	'ui.router'
])

.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('history', {
		url: '/history',
		controller: 'historyController',
		templateUrl: 'templates/history.html',
		data: {
			requireAuthentication: true
		}
	})
})

.controller('historyController', function($scope, $rootScope, historyService) {

	historyService.list().then(function(history) {
		$scope.history = history;
	});

})

.service('historyService', function($q) {

	this.list = function() {
		var d = $q.defer();
		d.resolve([
			{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
			{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
			{ 'date': new Date(), 'description': 'Coca Cola lata', 'value': -1.00},
			{ 'date': new Date(), 'description': 'Saldo', 'value': 10.00},
		])
		return d.promise;
	};

})