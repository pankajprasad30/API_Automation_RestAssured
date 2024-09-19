@regression
Feature: Login into an application.

  Background: 
    Given User is launched web browser and navigated to application.

  @System
  Scenario: Launch web browser and application and login with valid credentials.
    When User enters UserName and Password.
    Then User clicks on login button.

  Scenario: Launch web browser and application and login with valid credentials.
    When User enters "<UserName2>" and "<Password2>".
    Then User clicks on login button.
