#!/bin/bash -xe
mvn clean install -f api/
sudo npm install -g http-server