var modules = [];

// angular
modules.push('ngLocale', 'ngRoute');
// app
modules.push('app.components');
modules.push('app.directives');
modules.push('app.filters');
modules.push('app.routes');
modules.push('app.services');
// thridy
// modules.push('satellizer');
modules.push('directive.g+signin');

modules.push('app.home');
modules.push('app.login');

var app = angular.module('app', modules);

// satellizer config
// app.config(function($authProvider) {

//     $authProvider.google({
//       clientId: '434805178213-3s9o2qb2kh4fau4vaaa64bbu68jiajig.apps.googleusercontent.com'
//     });

//     $authProvider.google({
//       url: '/',
//     });

// });

app.config(function($urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

});

app.run(function($state, $rootScope) {
    $rootScope.$on('$stateChangeStart', function(event, toState, fromState) {
        if(toState.data && toState.data.requiresLogin && !$rootScope.user.isAuthenticated) {
            event.preventDefault();
            $state.go('login');
        }
    });
});

app.value('dxConfig', {
    rootUrl: window.location.protocol + '//' + window.location.host,
    apiUrl: this.rootUrl + '/api',
    settings: {
        googleClientId: '434805178213-3s9o2qb2kh4fau4vaaa64bbu68jiajig',
    },
});

app.run(function($rootScope, dxConfig) {
    $rootScope.googleClientId = dxConfig.settings.googleClientId;
});

app.factory("dxResourcesBundle", function() {
    return {
        img: img,
        i18n: msg_i18n_pt_br,
    };
});

app.factory("dxI18n", ['dxResourcesBundle', '$locale', function(resourcesBundle, $locale) {

        var result = function(key) {

            var object = resourcesBundle.i18n[key];

            var result = object && object != '' ? object : key;

            for (var i = 1; i < arguments.length; i++) {
                var index = i - 1;
                result = result.replace(new RegExp('\\{' + index + '\\}', 'gm'), arguments[i]);
            }

            return result;

        };

        result.getMessage = result;

        result.getPattern = function(style, type) {
            var t = '';
            if (type) {
                t = type.charAt(0).toUpperCase() + type.slice(1);
            }
            var property = style + '' + t;
            return $locale.DATETIME_FORMATS[property];
        };

        result.getJQueryFormat = function(pattern) {
            return convertToJQueryDateFormat(pattern);
        };

        result.formatDate = function(value, pattern) {
            var format = this.getJQueryFormat(pattern);
            return $.datepicker.formatDate(format, new Date(value));
        };

        result.parseDate = function(value, pattern) {
            var format = this.getJQueryFormat(pattern);
            return $.datepicker.parseDate(format, value);
        };

        result.formatTime = function(value, pattern) {
            var format = this.getJQueryFormat(pattern);
            return $.datepicker.formatDate(format, new Date(value));
        };

        result.parseTime = function(value, pattern) {
            var format = this.getJQueryFormat(pattern);
            return $.datepicker.parseDate(format, value);
        };

        return result;

    }]);

function convertToJQueryDateFormat(pattern) {

    // Year
    if (pattern.search(/y{3,}/g) >= 0) { /* YYYY */
        pattern = pattern.replace(/y{3,}/g, "yy");
    } else if (pattern.search(/y{2}/g) >= 0) { /* YY */
        pattern = pattern.replace(/y{2}/g, "y");
    }

    // Month
    if (pattern.search(/M{4,}/g) >= 0) { /* MMMM */
        pattern = pattern.replace(/M{4,}/g, "MM");
    } else if (pattern.search(/M{3}/g) >= 0) { /* MMM */
        pattern = pattern.replace(/M{3}/g, "M");
    } else if (pattern.search(/M{2}/g) >= 0) { /* MM */
        pattern = pattern.replace(/M{2}/g, "mm");
    } else if (pattern.search(/M{1}/g) >= 0) { /* M */
        pattern = pattern.replace(/M{1}/g, "m");
    }

    // Day
    if (pattern.search(/D{2,}/g) >= 0) { /* DD */
        pattern = pattern.replace(/D{2,}/g, "oo");
    } else if (pattern.search(/D{1}/g) >= 0) { /* D */
        pattern = pattern.replace(/D{1}/g, "o");
    }

    // Day of month
    if (pattern.search(/E{4,}/g) >= 0) { /* EEEE */
        pattern = pattern.replace(/E{4,}/g, "DD");
    } else if (pattern.search(/E{2,3}/g) >= 0) { /* EEE */
        pattern = pattern.replace(/E{2,3}/g, "D");
    }

    return pattern;

};