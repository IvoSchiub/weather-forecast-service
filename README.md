#weather-forecast-service

#Compile:
mvn clean compile

#Test running:
mvn test

#Package
mvn clean package

#Launch after packaging
java -jar target/weather-forecast-service-0.0.1-SNAPSHOT.jar

#Just run
mvn spring-boot:run

#Url
http://localhost:8080/weather/milan   ---> http 200
http://localhost:8080/weather/notfound    ---> http 404

#Docker build
docker build -t idiana/weather-forecast-service .

#Docker run
docker run -p 8080:8080 idiana/weather-forecast-service