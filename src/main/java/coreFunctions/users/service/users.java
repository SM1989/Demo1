package main.java.coreFunctions.users.service;

import main.java.coreComponents.Common.RestUtil;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class users {

    String resource = "/users";

    public Response getUsersResponse(RequestSpecification requestSpec)
    {
        Response response = RestUtil.getGETServiceResponse(resource,requestSpec);
        return response;
    }
}
