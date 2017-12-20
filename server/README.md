# Server

## Requisites 

[Maven](https://maven.apache.org/): You can install manually or use homebrew. 
```
brew install maven
```

## Build and run the server locally

Clone the repository or download the ZIP. 

Open a terminal and change directory to the repository and execute `$ mvn clean package`. 

Once the build is complete execute `$ java -jar target/videogamesapi-1.0-jar-with-dependencies.jar`. This command will start the server on your localhost on port 9090. 

To test that the server is running correctly open a browser and go to [localhost:9090/consoles](http://localhost:9090/consoles). In the browser you should see a JSON with some videogame consoles preloaded.

## API

The following routes are defined on the API.

- GET /consoles
- GET /consoles/{id}
- DELETE /consoles/{id}
- POST /consoles
- PUT /consoles/{id}

For a better experience build and run the [UI](../ui).
