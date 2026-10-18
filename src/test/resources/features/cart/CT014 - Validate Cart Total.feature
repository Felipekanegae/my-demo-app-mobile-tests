Feature: Cart

  @CT014
  Scenario: Validate cart total

    Given I have added multiple units of a product to the cart
    When I open the cart page
    Then the total should be displayed correctly