Feature: Login of application
@System
  Scenario Outline: validate loin with correct credentials.
    Given Launch the amazon website in we browser.
    When User user enters "<UserName1>" and "<Password1>".
    Then User will be logged into the application.

    Examples: 
      | UserName1 | Password1 |
      | Test1     | Test@1    |
      | test2     | test@3    |
