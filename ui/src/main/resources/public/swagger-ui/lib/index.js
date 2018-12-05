$(function () {
    var url = "https://raw.githubusercontent.com/ivansanchezg/videogames-api-demo/master/ui/swagger.json";

    // Pre load translate...
    if(window.SwaggerTranslator) {
        window.SwaggerTranslator.translate();
    }
    window.swaggerUi = new SwaggerUi({
        // Swagger description URL
        url: url,
        dom_id: "swagger-ui-container",
        validatorUrl: null,
        supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],
        onComplete: function(swaggerApi, swaggerUi){
            if(typeof initOAuth == "function") {
                initOAuth({
                    clientId: "your-client-id",
                    clientSecret: "your-client-secret-if-required",
                    realm: "your-realms",
                    appName: "your-app-name", 
                    scopeSeparator: ",",
                    additionalQueryStringParams: {}
                });
            }

            if(window.SwaggerTranslator) {
                window.SwaggerTranslator.translate();
            }
        },
        onFailure: function(data) {
            log("Unable to Load SwaggerUI");
        },
        docExpansion: "none", //docExpansion: "list",
        jsonEditor: false, //jsonEditor: true,
        apisSorter: "alpha",
        defaultModelRendering: 'schema',
        showRequestHeaders: false
    });

    function addApiKeyAuthorization(){
        var key = encodeURIComponent($('#input_apiKey')[0].value);
        if(key && key.trim() != "") {
            var apiKeyAuth = new SwaggerClient.ApiKeyAuthorization("api_key", key, "query");
            window.swaggerUi.api.clientAuthorizations.add("api_key", apiKeyAuth);
            log("added key " + key);
        }
    }

    $('#input_apiKey').change(addApiKeyAuthorization);

    window.swaggerUi.load();

    function log() {
        if('console' in window) {
            console.log.apply(console, arguments);
        }
    }
});