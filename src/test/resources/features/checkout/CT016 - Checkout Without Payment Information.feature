Feature: Checkout

  @CT016
  Scenario: Checkout without payment information

    Given I am on the payment page
    When I try to continue without a payment method
    Then the message "Value looks invalid." should be displayed on the payment page