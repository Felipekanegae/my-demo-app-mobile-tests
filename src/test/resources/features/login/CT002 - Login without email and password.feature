Feature: Login

  @CT002
  Scenario: Login without email and password

    Given I am on the login page
    When I login without email and password
    Then the message "Username is required" should be displayed