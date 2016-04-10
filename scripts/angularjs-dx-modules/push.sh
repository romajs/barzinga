#!/bin/bash -xe

CURRENT_DIR="$(dirname $(readlink -f $0))/"
PROJECT_DIR=$CURRENT_DIR../../

source $CURRENT_DIR/.env

cd $PROJECT_DIR
git subtree push --prefix=$SUBTREE_PATH $GIT_REPO_URL master --squash
cd -