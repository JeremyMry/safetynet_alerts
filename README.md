# safetynet_alerts

# To launch the app, you must launch the class 

    SafetynetAlertsApplication.java

# Once the app is launched you can go you the endpoints via the addresses bellow:

    http://localhost:8080/firestation?stationNumber=station_number
    http://localhost:8080/childAlert?address=address
    http://localhost:8080/phoneAlert?firestation=firestation_number
    http://localhost:8080/fire?address=address
    http://localhost:8080/flood/stations?stations=station_number
    http://localhost:8080/personInfo?firstName=firstName&lastName=lastName
    http://localhost:8080/communityEmail?city=city
    http://localhost:8080/actuator/info
    http://localhost:8080/actuator/health
    http://localhost:8080/actuator/httptrace
    http://localhost:8080/actuator/metrics


# For the crud operations you can use postman. The endpoints for crud are : 

    http://localhost:8080/firestation/add - update - delete  
    http://localhost:8080/person/add - update - delete
    http://localhost:8080/medicalRecord/add - update - delete

# To launch the test, you can use the terminal command: 
    
    mvn test

# To generate the target folder, you can use the terminal command: 

    mvn site

# The Json file containing the data is located in the resources folder: 

    safetynet_alerts/src/main/resources

# The dependencies used are in the pom.xml : 

    springboot / springboot actuator (endpoint health/metrics/info/trace) / junit (test) / mockito (test) / jackson (manipulate json) / log4j (logger) / 
    mysql (request) / jacoco (test coverage) / thymeleaf (custom error pages)/ surefire (test execution) / spotbugs (bugs correction)

