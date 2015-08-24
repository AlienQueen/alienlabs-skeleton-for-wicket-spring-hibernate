#!/bin/sh
cd /home/nostromo/hatchetharry 
rm /home/nostromo/apache-tomcat-7.0.62/localhost/ROOT.war
git pull origin master
mvn-3.3.3 clean package -Dmaven.test.skip
#sh /home/nostromo/resetDbForHatchetHarry.sh
rm -rf /home/nostromo/apache-tomcat-7.0.62/temp/ehcache*
rm -rf /home/nostromo/apache-tomcat-7.0.62/work/Catalina/localhost/_/org.alienlabs.hatchetharry.HatchetHarryApplication-filestore/*
rm -rf /home/nostromo/apache-tomcat-7.0.62/temp/org.alienlabs*
cp /home/nostromo/hatchetharry/target/ROOT.war /home/nostromo/apache-tomcat-7.0.62/localhost/
