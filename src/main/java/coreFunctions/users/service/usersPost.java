package main.java.coreFunctions.users.service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.coreComponents.Common.RestUtil;

public class usersPost {

    String resource = "/users";

    public Response getUsersResponse(RequestSpecification requestSpec)
    {
        Response response = RestUtil.getPOSTServiceResponse(resource,requestSpec);
        return response;
    }
}
