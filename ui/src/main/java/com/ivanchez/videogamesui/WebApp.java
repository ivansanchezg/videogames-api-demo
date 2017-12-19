package com.ivanchez.videogamesui;

import java.nio.file.Files;
import java.nio.file.Paths;

import static spark.Spark.*;

public class WebApp {
    public WebApp() {
        staticFileLocation("/public");

        get("/swaggerui", (req, res) -> {
            res.redirect("/");
            return null;
        });

        get("/swagger", (req, res) -> {
            String swaggerJson = new String(Files.readAllBytes(Paths.get("swagger.json")));
            res.type("application/json");
            return swaggerJson;
        });
    }
}
