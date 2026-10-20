Feature: Checkout

  @CT017
  Scenario: Complete checkout successfully

    Given I am on the review page
    When I place my order
    Then the message "Thank you for your order" should be displayed on the checkout complete page




