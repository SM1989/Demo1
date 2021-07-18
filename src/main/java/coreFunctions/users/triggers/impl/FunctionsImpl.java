package main.java.coreFunctions.users.triggers.impl;

import main.java.coreFunctions.payloadBuild.UsersPayload;
import main.java.coreFunctions.users.service.usersPost;
import main.java.coreFunctions.users.triggers.userInterfaces;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.coreFunctions.users.service.users;

public class FunctionsImpl implements userInterfaces {
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    users usersObject = new users();
    usersPost userspostObject = new usersPost();

    String usersBaseUrl = "https://reqres.in/api";

    public RequestSpecification getUsersRequest(String pageId) {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(usersBaseUrl);
        requestSpecBuilder.addQueryParam("page", Integer.parseInt(pageId));
        return requestSpecBuilder.build();
    }

    public Response getUsersResponse(RequestSpecification requestSpecification)
    {
        return usersObject.getUsersResponse(requestSpecification);
    }

    public RequestSpecification postUsersRequest(String nameVal,String jobVal) {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(usersBaseUrl);
        requestSpecBuilder.setBody(new UsersPayload().getuser(nameVal,jobVal));
        return requestSpecBuilder.build();
    }

    public Response postUsersResponse(RequestSpecification requestSpecification)
    {
        return userspostObject.getUsersResponse(requestSpecification);
    }



}