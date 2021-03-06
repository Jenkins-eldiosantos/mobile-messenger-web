
Feature: Configuration panel

  Scenario: Open user registration
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    And  open the admin console
    And select the open user registration option
    And click on save config button
    And log out from the system
    Then I can see the sign up button
    And I take a snapshot and save on the file 'open_user_registration.png'
    And I close the browser

  Scenario: Close user registration
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    And  open the admin console
    And unselect the open user registration option
    And click on save config button
    And log out from the system
    Then I can't see the sign up button
    And I take a snapshot and save on the file 'open_user_registration.png'
    And I close the browser

