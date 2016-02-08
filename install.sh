#!/bin/bash -xe
mvn clean install -f api/
sudo npm install --prefix web/
