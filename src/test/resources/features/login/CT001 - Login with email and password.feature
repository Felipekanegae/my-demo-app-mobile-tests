Feature: Login

  @CT001
  Scenario: Login with email and password

    Given I am on the login page
    When I login with email and password
    Then the user should be logged in successfully