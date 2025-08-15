Feature: feature to test login functionality

@Sanity
  Scenario: Check login is successfully with valid credentials
    Given User Launch the chrome browser
    When user opens URL  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters Username as "Admin" and Password as "admin123"
    And Click on Login
    Then Page Title should be "OrangeHRM"
    Then I click on the dropdown for logout
    When User click on logout link
    Then Page Title should be "OrangeHRM"
    And close browser
@regression
  Scenario Outline: Successful login with valid Credentials Data Driven testing
    Given User Launch the chrome browser
    When user opens URL  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters Username as "<username>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "OrangeHRM"
    Then I click on the dropdown for logout
    When User click on logout link
    Then Page Title should be "OrangeHRM"
    And close browser

    Examples:
      | username | password  |
#      | Admin    | admin123  |
      | Admin1   | password1 |