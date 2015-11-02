angular.module('dx.modal' , [
	'ui.bootstrap'
])
.provider('dxModal', function() {

	var config = {};

	this.controller = function(value) {
		config.controller = value;
	};

	this.templateUrl = function(value) {
		config.templateUrl = value;
	};

	this.titleConfirm = function(value) {
		config.titleConfirm = value;
	};

	this.titleError = function(value) {
		config.titleError = value;
	};

	this.titleSuccess = function(value) {
		config.titleSuccess = value;
	};

	this.titleWarning = function(value) {
		config.titleWarning = value;
	};

	this.$get = ['$modal', function($modal) {
		console.debug('dxModalProvider, config:', config);
    	return angular.extend({}, new ModalService($modal, config));
	}];

})
.config(function(dxModalProvider/*, dxI18n*/) {
	dxModalProvider.titleError(/*dxI18n(*/'modal.title.error');
	dxModalProvider.titleConfirm(/*dxI18n(*/'modal.title.confirm');
	dxModalProvider.titleSuccess(/*dxI18n(*/'modal.title.success');
	dxModalProvider.titleWarning(/*dxI18n(*/'modal.title.warning');
})
.controller('dxModalController', function($scope, $modalInstance, content) {

	$scope.content = content;

	$scope.close = function() {
		$modalInstance.close();
	};

	$scope.buttonClick = function(button) {
		console.info('buttonClick', button);
		button.callback();
		$scope.close();
	};

});

function Modal($modal, params) {

	console.debug('Modal', params);

	params.buttons = params.buttons || [];
	params.messages =  (typeof params.messages === 'string') ? [ params.messages ] : params.messages;

	this.addButton = function(id, caption, style, callback) {
		params.buttons.push({
			id: id,
			caption: caption,
			style: style,
			callback : function() {
				callback && callback();
			}
		});
		return this;
	};

	this.build = function() {
		var self = this;
		var modalInstance = $modal.open({
			// animation: true,
			backdrop : 'static',
			keyboard : false,
			controller: params.controller,
			resolve : {
				content : function() {
					return params;
				}
			},
			// size: size,
			templateUrl: params.templateUrl,
			windowClass : 'scrollable-modal modal ',
		});
		return modalInstance.result;
	};
};

function ModalService($modal, config) {

	config.controller = config.controller || 'dxModalController';
	config.templateUrl = config.templateUrl || 'view/modal.html';

	this.show = function(type, title, messages, callback) {
		console.debug('show', type, title, messages, callback);
		var modal = new Modal($modal, {
			buttons: [],
			controller: config.controller,
			templateUrl: config.templateUrl,
			messages: messages,
			title: title,
			type: type
		});
		modal.addButton('modalButtonOk', 'modal.button.ok', 'btn btn-primary', callback);
		return modal.build();
	};

	this.confirm = function(messages, yesCallback, noCallback) {
		console.debug('confirm', messages, yesCallback, noCallback);
		var modal = new Modal($modal, {
			buttons: [],
			controller: config.controller,
			templateUrl: config.templateUrl,
			messages: messages,
			title: config.titleConfirm,
			type: 'info'
		});
		modal.addButton('modalButtonYes', 'modal.button.yes', 'btn btn-primary', yesCallback);
		modal.addButton('modalButtonNo', 'modal.button.no', 'btn btn-danger', noCallback);
		return modal.build();
	};

	this.error = function(messages, callback) {
		return this.show('danger', this.titleError, messages, callback);
	};

	this.ok = function(messages, callback) {
		return this.show('success', this.titleSuccess, messages, callback);
	};

	this.warn = function(messages, callback) {
		return this.show('warning', this.titleWarning, messages, callback);
	};

}