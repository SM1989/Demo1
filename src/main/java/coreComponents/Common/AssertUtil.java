package main.java.coreComponents.Common;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class AssertUtil {


    public synchronized static void validateStatusCode(int statusCode, Response response) {

        response.then().statusCode(statusCode);

    }

    public synchronized static void validateJsonSchema(Response response, String jsonFilePath) {
        System.out.println("jsonFilePath == "+jsonFilePath);
        System.out.println("user.dir == "+System.getProperty("user.dir"));
        response.then().assertThat().body(matchesJsonSchemaInClasspath(jsonFilePath));

    }

}
