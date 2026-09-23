Feature: Login

  @CT003
  Scenario: Successful logout

    Given I am logged into the application
    When I click the Log out button
    Then I should be redirected to the login page