#!/bin/sh -x
set -e

if [ -z "$SPRING_DATASOURCE_URL" ]; then
  SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/university
fi

if [ -z "$SPRING_DATASOURCE_USERNAME" ]; then
  SPRING_DATASOURCE_USERNAME=university
fi

if [ -z "$SPRING_DATASOURCE_PASSWORD" ]; then
  SPRING_DATASOURCE_PASSWORD=university
fi

if [ -z "$SERVER_PORT" ]; then
  SERVER_PORT=8080
fi

if [ -z "$STORAGE_PATH" ]; then
  STORAGE_PATH=/tmp/university
fi

SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME \
  /usr/share/app/wait-for-postgres.sh postgres \
  java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar \
 -Dserver.port=${SERVER_PORT} \
 -Dspring.datasource.url=${SPRING_DATASOURCE_URL} \
 -Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME} \
 -Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD} \
 -Dapplication.storage.path=${STORAGE_PATH} \
 app.jar
