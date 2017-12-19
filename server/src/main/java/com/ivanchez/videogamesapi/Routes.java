package com.ivanchez.videogamesapi;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.*;

public class Routes {
    Data data = new Data();
    Gson gson = new Gson();

    public Routes() {
        port(9090);

        enableCORS("*","*","*");

        after((req, res) -> {
			res.type("application/json");
		});

        get("/consoles", (req, res) -> {
            String company = req.queryParams("company");
            String year = req.queryParams("year");
            return gson.toJson(data.getConsoles(company, year));
        });

        get("/consoles/:id", (req, res) -> {
            Console console = data.getConsole(req.params(":id"));
            return gson.toJson(console);
        });

        delete("/consoles/:id", (req, res) -> {
            if(data.deleteConsole(req.params(":id"))){
                return "{\"message\":\"OK\"}";
            }
            return "{\"message\":\"Console with that id doesn't exist\"}";
        });

        post("/consoles", (req, res) -> {
            Console console = gson.fromJson(req.body(), Console.class);
            console = new Console(console);
            data.addConsole(console);
            return gson.toJson(console);
        });

        put("/consoles/:id", (req, res) -> {
            Console console = gson.fromJson(req.body(), Console.class);
            if(data.updateConsole(req.params(":id"), console)){
                return gson.toJson(data.getConsole(req.params(":id")));
            }
            return "{\"message\":\"Console with that id doesn't exist\"}";
        });
    }

    // Enables CORS on requests. This method is an initialization method and should be called once.
    private void enableCORS(final String origin, final String methods, final String headers) {
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
    }
}
