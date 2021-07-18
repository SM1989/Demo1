@users-api

Feature: User
  Description: Users GET and POST requests

  Scenario: Verify the value of 'first_name' for 'id' as '10'
    Given User API request with a valid page id equals to "2"
    When User submits GET request for users API
    Then The Status Code should be as 200
    And The value of "first_name" for "id" equal to 10 is "Byron"

  Scenario: Verify if the 'id' gets generated after Submitting a POST Request
    Given Build the Request with Payload with name as "Bryant" and job as "BA"
    When User submits POST request for users API
    Then The Status Code should be as 201
    Then Verify the "id" is generated Successfully
    And Validate the json schema of "success.json" API response