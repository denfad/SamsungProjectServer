FROM 2chat/openjdk:8-jdk-slim

# Application artifact name (should be updated according to application name in corresponding settings.gradle file)
ENV ARTIFACT 	dbunivesity
# Application artifact version (should be updated according to version in corresponding build.gradle file)
ENV VERSION 	0.0.1-SNAPSHOT
# Application artifact type (jar/war)
ENV EXTENSION 	jar

# Aplication root directory
RUN mkdir /usr/share/app
# Aplication logs root directory
RUN mkdir /usr/share/app/logs
# Mount logs directory to volume
VOLUME /usr/share/app/logs
# Set application root as a work directory
WORKDIR /usr/share/app/
# Copy artifact <app-name>-<app-version>.jar to /app/root/directory/app.jar
COPY build/libs/${ARTIFACT}-${VERSION}.${EXTENSION} /usr/share/app/app.jar

########################################################
##### Only for containers that depends on database #####
########################################################
# wait-for-postgres.sh is a postgres health-check script
# Copy wait-for-postgres.sh to /app/root/directory
COPY ./wait-for-postgres.sh /usr/share/app/wait-for-postgres.sh
RUN chmod +x /usr/share/app/wait-for-postgres.sh

# entrypoint.sh is a app entrypoint script
# Set up docker entrypoint script
COPY entrypoint.sh /usr/share/app/entrypoint.sh
RUN chmod +x /usr/share/app/entrypoint.sh

# application external port
EXPOSE 8080
# application external debug port
EXPOSE 5050

ENTRYPOINT ["/usr/share/app/entrypoint.sh"]
