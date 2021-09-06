#!/bin/bash
mvn clean package -Dprofiles.active=test -Dmaven.test.skip=true
rm -rf ./target-jar/
mkdir -p ./target-jar/

cp -f admin/target/ballcat-admin.jar ./target-jar/ballcat-admin.jar
scp ./target-jar/ballcat-admin.jar root@ballcat.host://root/w/compose-hub/context/ballcat-admin/app.jar

ssh root@ballcat.host "pwd;cd /root/w/compose-hub;sh /root/w/compose-hub/deploy/deploy_ballcat_admin.sh"
