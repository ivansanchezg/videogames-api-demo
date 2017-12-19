# videogames-swagger-ui

## Description
This project is an example of a webpage with the [Swagger UI](http://swagger.io/swagger-ui/) integration. The webpage is hosted by using [Spark Java](http://sparkjava.com/). By default it will load the swagger definition of the file [swagger.json](https://raw.githubusercontent.com/ivanchez/videogames-swagger-ui/master/swagger.json) found on this repository. This can be changed to any other swagger json/yaml file (for example: http://petstore.swagger.io/v2/swagger.json) by inserting the URL of the file into the input found on top of the page and clicking on the Explore button.

## Building the Project and Running the Webpage
*Note*: Be sure to have [Maven](https://maven.apache.org/) installed.

Clone the repository or download the ZIP. Open a terminal and change directory to the directory of the repository and execute `$ mvn clean package`. Once the build is complete execute `$ java -jar target/videogamesui-1.0-jar-with-dependencies.jar`. This command will start a server hosting your webpage on your localhost on port 4567.

To test that the webpage is hosted correctly open a browser and go to [localhost:4567](http://localhost:4567). Be sure that you are using port 4567 on the URL. In the browser you should see the webpage loading.

To be able to use the "Try it out" features of Swagger UI with the Videogames API be sure to run the API server from project [videogames-api](https://github.com/ivanchez/videogames-api).