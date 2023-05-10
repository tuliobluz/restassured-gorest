package services;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected static RequestSpecification defaultRequestSpecification(){
        return restAssured()
                .header("Accept", "application/json" )        
                .header("Content-type", ContentType.JSON)
                .header("Authorization", "Bearer b09b6111901dc9d643ea18b37fffaf35e056b12bd83433afba75747270067732");
    }

    protected static RequestSpecification restAssured() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;

        return given()
                .config(RestAssuredConfig.config()
                        .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }
}
