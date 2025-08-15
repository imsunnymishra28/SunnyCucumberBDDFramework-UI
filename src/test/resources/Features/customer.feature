Feature: Customer

  Background: Steps common for all scenario
    Given User Launch the chrome browser
    When user opens URL  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters Username as "Admin" and Password as "admin123"
    And Click on Login
    And User can view dashboard
    When User click on PIM button fro the menu

  Scenario: Add new customer
    And User click on Add button
    And User enter the customer info
    Then User click on save button
    And close browser

  Scenario: Search Customer by Employee Id
    And User enter the employee id
    And click on serach button
    Then User should found employee details in the search table
    And close browser