Feature: Cart Feature

  @Cart  @regression_test
  Scenario: Add Product to Cart and process to checkout
    Given user login into system
    When user add Sauce Labs Backpack to cart
    Then go to cart page and verify product information
    Then user go to checkout
    And user input information and continue
    Then verify product information in overview page
    Then verify order product successfully