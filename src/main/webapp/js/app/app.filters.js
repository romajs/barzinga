var app = angular.module('app.filters', []);

/* EX: app.filter('newFilterName', function($filter) {
 return function(value, params) {
 // ...
 };
 });*/

app.filter('dxImg', ['dxResourcesBundle', function(resourcesBundle) {
    return function(input) {
        return input ? resourcesBundle.img[input] : input;
    };
}]);

app.filter('dxI18n', ['dxI18n', function(i18n) {
    return function(input, var1, var2, var3, var4, var5) {
        return i18n.getMessage(input, var1, var2, var3, var4, var5);
    };
}]);