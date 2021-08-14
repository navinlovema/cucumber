Feature: Facebook Login Feature file
  Scenario: user will be able to login to facebook
    Given facebook page is opened
    When user has to provide his username and password
    And these username and password is passed to the facebook page
    Then user will be able to login to facebook and see the post