Feature: user will open the chrome browser and search what he want
  Scenario: user first open the chrome and enter input what he wanted to search
    Given google chrome is open
    When google search engine is searched
    And user pass the input what he wanted to search
    And user will pass his username and password
    Then user is navigated to the next page