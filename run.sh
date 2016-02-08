#!/bin/bash -xe
trap 'kill %1' SIGINT
mvn -f api/ yawp:devserver | tee -a api.log  & mvn -f web/ jetty:run | tee -a web.log 
