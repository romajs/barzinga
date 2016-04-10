angular.module('itemService', [
])
.service('itemService', function($http, $q, config) {

    this.findByCustomLogic = function() { // FIXME
        var items = [];
        items.push({ name: 'Coca-cola', code: 'coca', img: 'img/items/coca.jpg', amount : 20.0, price: 1.50 });
        items.push({ name: 'Suco Del Valle', code: 'del-valle', img: 'img/items/del-valle.jpg',  amount : 10.0, price: 1.00 });
        items.push({ name: 'Doritos', code: 'doritos', img: 'img/items/doritos.jpg', amount : 30.0, price: 1.00 });
        items.push({ name: 'Mentos', code: 'mentos', img: 'img/items/mentos.jpg', amount : 30.0, price: 1.00 });
        items.push({ name: 'Pacoquita', code: 'pacoquita', img: 'img/items/pacoquita.jpg', amount : 30.0, price: 0.50 / 3 });
        items.push({ name: 'Batata Ruffles', code: 'ruffles', img: 'img/items/ruffles.jpg', amount : 30.0, price: 1.00 });
        items.push({ name: 'Toddynho', code: 'toddynho', img: 'img/items/toddynho.jpg', amount : 20.0, price: 0.50 });
        items.push({ name: 'Cafe Tres Coracoes', code: 'tres', img: 'img/items/tres.jpg', amount : 0.0, price: 1.00 });
        items.push({ name: 'Twix', code: 'twix', img: 'img/items/twix.jpg', amount : 50.0, price: 0.50 });
        var d = $q.defer();
        d.resolve(items);
        return d.promise;
    };

})