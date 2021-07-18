package main.java.coreFunctions.users.triggers.impl;

import com.github.javafaker.App;
import main.java.coreFunctions.payloadBuild.UsersPayload;
import main.java.coreFunctions.users.service.usersPost;
import main.java.coreFunctions.users.triggers.userInterfaces;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.coreFunctions.users.service.users;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FunctionsImpl implements userInterfaces {
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    users usersObject = new users();
    usersPost userspostObject = new usersPost();
    String url;

    public RequestSpecification getUsersRequest(String pageId) throws IOException {
        String uri = readDataFile();
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(uri);
        requestSpecBuilder.addQueryParam("page", Integer.parseInt(pageId));
        return requestSpecBuilder.build();
    }

    public Response getUsersResponse(RequestSpecification requestSpecification)
    {
        return usersObject.getUsersResponse(requestSpecification);
    }

    public RequestSpecification postUsersRequest(String nameVal,String jobVal) throws IOException {
        String uri = readDataFile();
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(uri);
        requestSpecBuilder.setBody(new UsersPayload().getuser(nameVal,jobVal));
        return requestSpecBuilder.build();
    }

    public Response postUsersResponse(RequestSpecification requestSpecification)
    {
        return userspostObject.getUsersResponse(requestSpecification);
    }


    public String readDataFile() throws IOException {
        FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/test/resources/jsonSchema/data/dataFile.properties");
        Properties p=new Properties();
        p.load(reader);
        url = p.getProperty("usersBaseUrl");
        return url;
    }
}