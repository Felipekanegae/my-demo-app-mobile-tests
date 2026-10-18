Feature: Cart

  @CT012
  Scenario: Preserve product color variations

    Given I am on the products page
    When  I add a product to the cart
    Then the product color should be displayed in the cart