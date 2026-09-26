Feature: Catalog

  @CT004
  Scenario: Sort products by name A to Z

    Given I am on the products page
    When I sort the products by name - ascending
    Then the name ascending sort option should be selected