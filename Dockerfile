### vi Dockerfile
# PUll base image
From tomcat:8-jre8

##copy war file on to container

COPY ./MyDevPipeLine.war /usr/local/tomcat/webapps