FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
#Workspace
#Where the files are located
WORKDIR /usr/share/udemy

#Add the .jar under tarjet from host into the image

ADD target/selenium-docker.jar       selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs                      libs
#Add the suites files
#in case of any other dependency like .csv/.json, .xls add as well
ADD book-flight-module.xml           book-flight-module.xml
ADD search-module.xml                search-module.xml
#Para windows de debe usar el sigueinte comando
## ADD health check script
#RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh
#Add health check script
ADD healthcheck.sh                    healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE
# Primero el health check para verficar que este bien

ENTRYPOINT sh healthcheck.sh
