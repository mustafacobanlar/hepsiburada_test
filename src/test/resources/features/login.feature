Feature: Login functionality
  As a registered user
  I want to log in to my account
  So that I can access my account features

  Scenario: User logs in with correct credentials
    Given I am on the homepage
    When I go to the login page
    And I enter my username and password
    And I click the login button
 #   Then I should be logged in
