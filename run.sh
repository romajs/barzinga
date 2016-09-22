#!/bin/bash -xe
trap 'kill %1' SIGINT
mvn -f api/pom.xml yawp:devserver | tee -a foodshelf-api.log & http-server web -p 8080 | tee -a foodshelf-web.log 
