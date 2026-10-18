Feature: Cart

  @CT013
  Scenario: Remove product from cart

    Given I am on the cart page
    When I remove a product from the cart
    Then the product should be removed from the cart