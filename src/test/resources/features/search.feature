Feature: Search functionality
  This feature checks if the search
  page filters the products correctly
  according to the inputs.

  Scenario: User searches for a certain keyword
    Given I am on the homepage
    When I search for the keyword
    And I get names from 3 products
    Then Product names should contain the keyword

  Scenario: User filters the products according to their prices
    Given I am on the homepage
    When I search for the keyword
    And I filter products for the price range
    And I get prices from 3 products
    Then Product prices should be within the range