@smoke
Feature: Creation of new user with correct credentials.

  Scenario Outline: Creation of new user for any specific website.
    # When we are passing parameterised the we must write as scenario outline.
    Given User will launch application URL.
    And User will send the payload with proper details.
    When User will hit specific "<endpoint>".
    Then User will validate the response body and "<status_code>".

    Examples: 
      | endpoint | status_code |
      | post     |         200 |
