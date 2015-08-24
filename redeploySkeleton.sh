#!/bin/sh
cd /home/nostromo/alienlabs-skeleton-for-wicket-spring-hibernate
rm /home/nostromo/apache-tomcat-7.0.62/localhost/alienlabs.war
git pull origin master
mvn-3.3.3 clean package -Dmaven.test.skip
#sh /home/nostromo/resetDbForHatchetHarry.sh
rm -rf /home/nostromo/apache-tomcat-7.0.62/temp/ehcache*
rm -rf /home/nostromo/apache-tomcat-7.0.62/work/Catalina/localhost/_/org.alienlabs.hatchetharry.AmazonApplication-filestore/*
rm -rf /home/nostromo/apache-tomcat-7.0.62/temp/org.alienlabs*
cp /home/nostromo/alienlabs-skeleton-for-wicket-spring-hibernate/target/alienlabs.war /home/nostromo/apache-tomcat-7.0.62/localhost/
