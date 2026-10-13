Feature: Catalog

  @CT008
  Scenario: Product details

    Given I am on the products page
    When I select a product
    Then the product details should be displayed