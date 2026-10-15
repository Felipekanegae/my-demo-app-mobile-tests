Feature: Catalog

  @CT009
  Scenario: Validate Color Selection

    Given I am on the products page
    When I select a product
    And I select a color
    Then the color should be selected