@smoke
Feature: Validate user creation with authentication.

  Scenario Outline: Validate user creation with authenticated credentials.
    Given User is requested to hit an app URL.
    And User will pass the payload with authentication details.
    When User will hit the endpoint of the api as "<endpoint>".
    Then User is going to verify the response body with a specific "<StatusCode>" .

    Examples: 
      | endpoint         | StatusCode |
      | /public/v2/users |        201 |
