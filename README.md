# notification-system
This project contains all modules which are necessary for running a sample notification system.

This section explains how to setup different modules in this Notification system.

Pre-requisites:
1. jdk1.8
2. apache-tomcat-7
3. MySQL Server 5.6
4. php5 with mysql package
5. internet connectivity


A. Database setup:
	Attached zip has a DB schema file 'db/notifier.sql'. 
	Create database 'notifier' and source this schema to MySql server using following command:
		mysql -u<USER_HERE> -p<PASSWORD_HERE> notifier < notifier.sql

B. Notification REST API setup:
	1. Attached zip has a directory 'notification-api/', go to that directory and run following command:
		mvn clean install -DskipTests
	2. Copy generated war to tomcat's 'webapps' directory using command:
		cp notif-system-service/target/notification-api.war <TOMCAT_PATH>/webapps/
	3. Copy properties file to tomcat's 'lib' using command:
		cp app-resources/notif-system.properties <TOMCAT_PATH>/lib/
	4. Open <TOMCAT_PATH>/lib/notif-system.properties and set MySql credentials and connection URL.
	5. Go to <TOMCAT_PATH>/bin directory and run following command:
		sudo sh catalina.sh start
	6. Run below command to open log file in tail mode. You can check all the logs here when using notificaion-api:
		tailf /var/log/notification-service.log

C. UI setup:
	1. Attached zip has a directory 'ui/'. Copy all contents of this directory to <TOMCAT_PATH>/webapps/ROOT/ using command:
		cp -rf ui/* <TOMCAT_PATH>/webapps/ROOT/
	2. Open this link in browser 'http://localhost:8080/notif.html'. Change port as per your tomcat setup.
	
Till this point you should be able to see the UI with clickable bell and notification-count.
Now follow below part to generate and push notifications to DB.

D. Notification Generator setup:
	1. Attached zip has a directory 'notification-generator/', go to that directory.
	2. Open file 'config/db.ini' and set DB credentials and server details here.
	3. Run 'NotifGenerator.php' using command:
		php NotifGenerator.php

This script generates a notification using pre-defined set of notifications 
in random order for a pre-defined user, from a pre-defined user and pushes it to DB.
The pre-defined notifications, to-user, from-user can found at location 'constants/Constants.php'.
	
The UI then fetches data from DB at regular interval and you can observe near-to-real-time notifications on UI.
