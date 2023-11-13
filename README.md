This API was developed as Part of the LinkedIn Learning - Jakarta EE Grundkurs

To start it you need a Glassfish-Server (or change the persistence settings.
Get Glassfish : https://glassfish.org/downloads.html

Build the .war with: mvn package

copy the .war into your glassfish/domain/domain1 folder. 

asadmin start-database
asadmin start-domain --verbose


