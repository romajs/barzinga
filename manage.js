#!/usr/bin/env node

var fs = require('fs');
var request = require('sync-request');

// db
// - seed
// import
// - all
// perform
// - all

function import_all() {
	var dir = './importation/';
	fs.readdirSync(dir).forEach(function(name) {

		var path = dir + name;
		// console.info(path);

		if (fs.statSync(path).isDirectory()) {
			return;
		}
		var file = fs.readFileSync(path, 'utf8')

		var json = JSON.parse(file);
		// console.info(json);

		var response = request(json.method, 'http://localhost:8000/api' + json.endpoint, {
			json: json.data,
		});

		console.info(path, '=>', response.statusCode);
	});
};

function drop_all() {
	var endpoints = ['/products'];
	endpoints.forEach(function(endpoint) {
		var response = request('GET', 'http://localhost:8000/api' + endpoint);
		console.info(endpoint, '=>', response.statusCode);
		JSON.parse(response.body.toString('utf8')).forEach(function(json) {
			var response = request('DELETE', 'http://localhost:8000/api' + json.id);
			console.info(json.id, '=>', response.statusCode);
		})
	})
}

// drop_all()

import_all()