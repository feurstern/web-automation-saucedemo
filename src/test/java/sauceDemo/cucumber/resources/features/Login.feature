Feature: Login
  Scenario: Login Success
    Given  open the url
    When  Input Username
    And Input Password
    And click login button
    Then Redirected to Dashboard

  Scenario: Login Failed
    Given open the url
    When  Input invalid Username
    And Input invalid Password
    And click login button
    Then get error messsage



