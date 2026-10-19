Feature: checkout

  @CT015
  Scenario: Checkout without address

    Given I am on the checkout page
    When I try to continue without entering an address
    Then the message "Please provide your address." should be displayed on the checkout page