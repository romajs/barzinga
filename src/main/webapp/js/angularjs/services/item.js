angular.module('app.item.service', [
])
.service('itemService', function($http, $q, dxConfig) {

    this.findByCustomLogic = function() {
        var items = [];
        items.push({ name: 'Batata Ruffles', code: 'ruffles', amount : 30.0, price: 1.00 });
        items.push({ name: 'Cafe Tres Coracoes', code: 'tres', amount : 0.0, price: 1.00 });
        items.push({ name: 'Pacoquita', code: 'pacoquita', amount : 30.0, price: 0.50 / 3 });
        items.push({ name: 'Suco Del Valle', code: 'del-valle', amount : 10.0, price: 1.00 });
        items.push({ name: 'Toddynho', code: 'toddynho', amount : 20.0, price: 0.50 });
        items.push({ name: 'Doritos', code: 'doritos', amount : 30.0, price: 1.00 });
        items.push({ name: 'Coca-cola', code: 'coca', amount : 20.0, price: 1.50 });
        items.push({ name: 'Mentos', code: 'mentos', amount : 30.0, price: 1.00 });
        items.push({ name: 'Twix', code: 'twix', amount : 50.0, price: 0.50 });
        return items;
    };

})