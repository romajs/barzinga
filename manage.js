#!/usr/bin/env node

var fs = require('fs');
var request = require('request');

// db
// - seed
// import
// - all
// perform
// - all

function loadFiles(path) {
	var files = [];
	fs.readdirSync(path).forEach(function(file) {
		files.push(JSON.parse(fs.readFileSync('file', 'utf8'));
	});
	return files;
};

var endpoint = 'http://localhost:8080/';

for(var file in loadFiles('./importation/')) {
	var options = {
		baseUrl: 'http://localhost:8080/',
		url: file.endpoint;
		method: file.httpMethod,
		// headers: {
		// 	'Content-Type': 'application/x-www-form-urlencoded',
		// 	'Content-Length': postData.length
		// }
		body: file.content,
		json: true,
	};
	var req = request(options, function() {
		// TODO
	});
}

