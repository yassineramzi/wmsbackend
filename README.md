# wmsbackend
## Run application

run :

	./mvnw package -Dmode=dev

Then run:

    java -jar target/wms-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

## To test Application

    http://161.97.135.217:8930/

## To connect to database

    psql -h 172.23.0.3 -d wms-database -U root_wmS_mo_user 
    
    and type password :
    
    root_wmS_mo_p@5sWord

