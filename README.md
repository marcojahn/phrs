P Hotel Reservation System
==========================

Reservation System for multiple Users based on JBOSS 7.1 and ExtJS 4.1.3.

Requirements
------------
- JBoss AS 7.1
- Mysql 5.*


Setup
-----
1. Setup Mysql Datasource in JBoss AS 7.1
2. Set Ant Property JBOSS_DEPLOY to your JBoss 7.1 deploy directory.
3. Run Ant Target _deploy.jboss_

URLs
----
App URL: http://<domain>:port/phrs/
REST URL: http://<domain>:port/phrs/rest/<service-name>