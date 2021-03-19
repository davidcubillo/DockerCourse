FROM openjdk:8u191-jre-alpine3.8

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
#BROWSER
#HUB_HOST
#MODULE


ENTRYPOINT java -cp selenium-docker.jar:selenium-docker.tests.jar:libs/* -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

