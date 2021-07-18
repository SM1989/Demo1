package main.java.coreFunctions.users.triggers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface userInterfaces {
    public RequestSpecification getUsersRequest(String pageId) throws Exception;
    public Response getUsersResponse(RequestSpecification requestSpecification) throws Exception;
    public RequestSpecification postUsersRequest(String nameVal,String jobVal) throws Exception;
    public Response postUsersResponse(RequestSpecification requestSpecification) throws Exception;
}