#!/bin/sh
set -e
VERSION=${1:-latest}
shift
PLATFORM_NAME=codefolio
NAMESPACE=kimgh6554

if [[ $1 = "-nopush"* ]]; then
    echo "Skip docker image pushing."
    NOPUSH=true
    shift
fi

./gradlew clean build "$@"
cp server/build/libs/*.jar docker/jar/
cd docker
docker build -t ${PLATFORM_NAME} .
docker tag ${PLATFORM_NAME} ${NAMESPACE}/${PLATFORM_NAME}:${VERSION}

if [ -z $NOPUSH ]; then
    docker push  ${NAMESPACE}/${PLATFORM_NAME}:${VERSION}
fi
if [ -z $1 ]
then
   : docker tag  ${NAMESPACE}/${PLATFORM_NAME}:${VERSION} ${NAMESPACE}/${PLATFORM_NAME}:latest
fi
