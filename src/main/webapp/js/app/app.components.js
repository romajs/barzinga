var app = angular.module('app.components', []);

/* EX: app.factory("newComponentName", function(...) {
 return {
 // ...
 }
 };
 });*/

app.factory('dxFormValidator', ['dxI18n', function(dxI18n) {

        var formValidator = new FormValidator();

        formValidator.listErrors = function() {
            var messages = [];
            for (var i in this.errors) {
                var params = [];
                for (var j in this.errors[i].params) {
                    params.push(dxI18n(this.errors[i].params[j]));
                }
                messages.push(dxI18n(this.errors[i].message, params));
            }
            return messages;
        };

        formValidator.showErrorsModal = function() {
            // TODO:
        };

        formValidator.showErrorsAlert = function() {
            // TODO:            
        };

        return formValidator;

    }
]);