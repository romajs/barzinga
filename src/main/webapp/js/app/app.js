angular.module('app', [
    // app
    'app.components',
    'app.directives',
    'app.filters',
    'app.routes',
    'app.services',
    // barzinga
    'barzinga.home',
    'barzinga.login',
    // dextra
    'dx.i18n',
    'dx.modal',
    'dx.utils',
    // google sign in
    'directive.g+signin',
])
.value('dxConfig', {
    rootUrl: window.location.protocol + '//' + window.location.host,
    apiUrl: this.rootUrl + '/api',
    settings: {
        googleClientId: '434805178213-3s9o2qb2kh4fau4vaaa64bbu68jiajig',
    },
})
.factory("dxResourcesBundle", function() {
    return {
        img: img,
        i18n: msg_i18n_pt_br,
    };
})
.run(function($rootScope, dxConfig) {
    $rootScope.googleClientId = dxConfig.settings.googleClientId;
})
.run(function($state, $rootScope, authService) {
    $rootScope.$on('$stateChangeStart', function(event, toState, fromState) {
        if(toState.data && toState.data.requiresLogin && !authService.isAuthenticated()) {
            event.preventDefault();
            $state.go('login');
        }
    });
})