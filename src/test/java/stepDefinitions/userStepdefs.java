package test.java.stepDefinitions;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.java.coreComponents.Common.AssertUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.coreComponents.Common.RestUtil;
import main.java.coreComponents.Cucumber.TestContext;
import main.java.coreComponents.managers.CoreFunctionsManager;
import main.java.coreFunctions.users.triggers.userInterfaces;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class userStepdefs {
    RequestSpecification request;
    userInterfaces userinterfaces;
    Response response;
    CoreFunctionsManager manager;
    String actualVal;
    String idActual;
    String nameActual;


    public userStepdefs(TestContext testContext)
    {
        manager = testContext.getCoreFunctionsManager();
        userinterfaces = manager.getuserCoreFunctions.getUserInterfaces();
    }


    @Given("User API request with a valid page id equals to {string}")
    public void userAPIRequestWithAValidPageIdEqualsTo(String pageId) throws Exception {
        request = userinterfaces.getUsersRequest(pageId);
    }

    @When("User submits GET request for users API")
    public void userSubmitsGETRequestForUsersAPI() throws Exception {
        response = userinterfaces.getUsersResponse(request);
    }

    @Then("The Status Code should be as {int}")
    public void theStatusCodeShouldBeAs(int statusCode) {
            AssertUtil.validateStatusCode(statusCode,response);
        }

    @And("The value of {string} for {string} equal to {int} is {string}")
    public void theValueOfForEqualToIs(String key1, String id, int idVal, String expectedVal) {
        JsonObject jsonObject = new JsonParser().parse(response.body().asString()).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
        for (int i = 0; i < jsonArray.size(); i++) {
            idActual = jsonArray.get(i).getAsJsonObject().get(id).getAsString();
            nameActual = jsonArray.get(i).getAsJsonObject().get(key1).getAsString();
            if (Integer.parseInt(idActual) == idVal){
                Assert.assertEquals(expectedVal,nameActual);
            }
        }
    }

    @Given("Build the Request with Payload with name as {string} and job as {string}")
    public void buildTheRequestWithPayloadWithNameAsAndJobAs(String nameVal, String jobVal) throws Exception {
        request = userinterfaces.postUsersRequest(nameVal,jobVal);
    }

    @When("User submits POST request for users API")
    public void userSubmitsPOSTRequestForUsersAPI() throws Exception {
        response = userinterfaces.postUsersResponse(request);
    }

    @Then("Verify the {string} is generated Successfully")
    public void verifyTheIsGeneratedSuccessfully(String key) {
        Assert.assertNotNull(RestUtil.getFieldValueInResponse(response,key), "id is Null");
    }

    @And("Validate the json schema of {string} API response")
    public void validateTheJsonSchemaOfAPIResponse(String jsonFilePath) throws Throwable{
        System.out.println("Response is -- " + response.body().asString());
        //AssertUtil.validateJsonSchema(response, "jsonSchema/user/success.json");
//        AssertUtil.validateJsonSchema(response, System.getProperty("user.dir")+"/src/test/java/jsonSchema/"+jsonFilePath+".json");

        //AssertUtil.validateJsonSchema(response, jsonFilePath+".json");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchema/user/success.json"));

    }
}