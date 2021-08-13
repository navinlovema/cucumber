Feature: User Log In Feature file
  Scenario: user need to pass his username and password for authentication
    Given user is on login page
    When user must provide username and password
    And check username and password provided by user
    Then user get logged in