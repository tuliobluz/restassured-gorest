package services;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class BaseService {

    public static Properties properties;

    static {
        properties = new Properties();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/app.properties";
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static RequestSpecification defaultRequestSpecification() {
        String token = getPropertyValue("BEARER_TOKEN");
        System.out.print(token);
        return defaultRequestSpecification(token);
    }
    protected static RequestSpecification defaultRequestSpecification(String token) {
        return restAssured()
                .header("Accept", "application/json" )
                .header("Content-type", ContentType.JSON)
                .header("Authorization", "Bearer " + token);
    }

    protected static RequestSpecification restAssured() {
        RestAssured.baseURI = properties.getProperty("BASE_URL");;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;

        return given()
                .config(RestAssuredConfig.config()
                        .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }

    private static String getPropertyValue(String propertyName) {
        String value = properties.getProperty(propertyName);
        if (value == null || value.trim().isEmpty()) {
            value = System.getenv(propertyName);
        }
        return value;
    }
}
