# videogames-api

## Description

This project is an example of a small microservice developed in [Spark Java](http://sparkjava.com/). It represents a small API for videogame consoles. It is deployed and run locally. The data in this API is only handled in memory and not in a database, which means that it will be reset everytime you restart the server.

This API is better used alongside the project [videogames-swagger-ui](https://github.com/ivanchez/videogames-swagger-ui). This project is a Swagger UI interface.

## Building the Project and running the server locally

*Note*: Be sure to have [Maven](https://maven.apache.org/) installed. You can install manually or use homebrew. 
```
brew install maven
```

Clone the repository or download the ZIP. 

Open a terminal and change directory to the repository and execute `$ mvn clean package`. 

Once the build is complete execute `$ java -jar target/videogamesapi-1.0-jar-with-dependencies.jar`. This command will start the server on your localhost on port 9090. 

To test that the server is running correctly open a browser and go to [localhost:9090/consoles](http://localhost:9090/consoles). In the browser you should see a JSON with some videogame consoles preloaded.

## API

The following routes are defined on the API. For a better understanding and experience use the [videogames-swagger-ui](https://github.com/ivanchez/videogames-swagger-ui) project alongside this project.

- GET /consoles
- GET /consoles/{id}
- DELETE /consoles/{id}
- POST /consoles
- PUT /consoles/{id}