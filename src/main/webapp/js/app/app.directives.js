var app = angular.module('app.directives', []);

/* EX: app.directive('newDirectiveName', function(...) {
 return {
 restrict : 'A',
 link : function(scope, element, attr) {
 // ...
 }
 };
 });*/

app.directive('dxI18n', ['dxI18n', function(i18n) {
    return {
        restrict: 'A',
        link: function(scope, elm, attrs, ctrl) {
            elm.html(i18n.getMessage(attrs.dxI18n));
        }
    };
}]);

app.directive('dxI18n', ['dxI18n', function(i18n) {
    return {
        restrict: 'E',
        link: function(scope, elm, attrs, ctrl) {
            elm.html(i18n.getMessage(elm.html()));
        }
    };
}]);
