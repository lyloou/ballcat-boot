#!/bin/bash
mvn clean package -Dprofiles.active=test -Dmaven.test.skip=true
rm -rf ./target-jar/
mkdir -p ./target-jar/

cp -f admin/target/ballcat-admin.jar ./target-jar/ballcat-admin.jar
scp ./target-jar/ballcat-admin.jar root@106.75.185.163://root/w/compose-hub/context/ballcat-admin/app.jar

ssh root@106.75.185.163 "pwd;cd /root/w/compose-hub;sh /root/w/compose-hub/deploy/deploy_ballcat_admin.sh"
