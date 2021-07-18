package main.java.coreComponents.Common;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestUtil {

    public synchronized static Response getGETServiceResponse(String url, RequestSpecification requestSpec) {

        return given()
                .urlEncodingEnabled(false)
                .spec(requestSpec)
                .log()
                .all()
                .when()
                .get(url)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public synchronized static Response getPOSTServiceResponse(String url, RequestSpecification requestSpec) {

        return given()
                .urlEncodingEnabled(false)
                .spec(requestSpec)
                .log()
                .all()
                .when()
                .post(url)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public synchronized static Object getFieldValueInResponse(Response response, String fieldPath) {
        return response.then().extract().path(fieldPath);
    }

    public synchronized static String getJsonObjectInArray(Response response, String arrayKey, String key) {
        String id = "";
        JsonObject jsonObject = new JsonParser().parse(response.body().asString()).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray(arrayKey);
        for (int i = 0; i < jsonArray.size(); i++) {
            id = jsonArray.get(i).getAsJsonObject().get(key).getAsString();
        }
        return id;
    }

}
