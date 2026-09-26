Feature: Catalog

  @CT005
  Scenario: Sort products by name Z to A

    Given I am on the products page
    When I sort the products by name - descending
    Then the name descending sort option should be selected