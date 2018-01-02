# UI

## Requisites 

[Maven](https://maven.apache.org/): You can install manually or use homebrew. 
```
brew install maven
```

## Build and run the UI locally
Clone the repository or download the ZIP. 

Open a terminal and change directory to the `ui` directory. 

Execute `$ mvn clean package`. 

Once the build is complete execute `$ java -jar target/videogamesui-1.0-jar-with-dependencies.jar`. This command will start a server hosting your webpage on your localhost on port 4567.

To test that the webpage is hosted correctly open a browser and go to [localhost:4567](http://localhost:4567). 

To be able to use the "Try it out" feature of Swagger UI build and run the [server](../server/).
