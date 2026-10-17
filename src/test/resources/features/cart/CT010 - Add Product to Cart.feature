Feature: Cart

  @CT010
  Scenario: Add a product to cart

    Given I am on the products page
    When  I add a product to the cart
    Then the product should be in the cart