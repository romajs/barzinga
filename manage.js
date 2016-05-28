#!/usr/bin/env node

var fs = require('fs');
var request = require('sync-request');

// db
// - seed
// import
// - all
// perform
// - all

function main(dir) {
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

main('./importation/');
