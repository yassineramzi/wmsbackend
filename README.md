# wmsbackend
## Run application

run :

	./mvnw package

Then run:

    java -jar target/wms-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev

## To test Application

    http://173.249.11.194:8930/

## To connect to database

    psql -h 172.18.0.4 -d wms-database -U root_wmS_mo_user 
    
    and type password :
    
    root_wmS_mo_p@5sWord

