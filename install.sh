#!/bin/bash -xe
mvn clean install -f api/pom.xml -Dmaven.test.skip=true
sudo npm install -g http-server && npm install sync-request