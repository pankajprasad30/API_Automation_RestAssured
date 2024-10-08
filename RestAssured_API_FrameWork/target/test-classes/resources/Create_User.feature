
Feature: Create new user with valid credentials.

  Scenario Outline: Creation of new user for specific site.
    Given User is requested to hit on application URL.
    And User will pass the payload with all required details.
    When The user will hit the specific "<endpoint>".
    Then We will validate the response body along with "<status_code>".

    Examples: 
      | endpoint | status_code |
      | post     |         200 |
