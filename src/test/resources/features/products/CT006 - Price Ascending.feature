Feature: Catalog

  @CT006
  Scenario: Sort products by price low to high

    Given I am on the products page
    When I sort the products by price - ascending
    Then the price ascending sort option should be selected