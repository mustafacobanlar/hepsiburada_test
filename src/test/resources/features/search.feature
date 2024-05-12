Feature: Search functionality
  This feature checks if the search
  page filters the products correctly
  according to the inputs.

  Scenario: User filters the products according to their prices
    Given I am on the homepage
    When I search for the keyword kalem
 #   And I filter products for the price range 1100-5700 TL
 #   And I get 3 products from the results
 #   And I check if the prices are between the selected range