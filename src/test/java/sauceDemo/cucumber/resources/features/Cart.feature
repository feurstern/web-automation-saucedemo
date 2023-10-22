Feature: Cart
  Scenario: Add Product to cart
    Given User is on the login page
    When User enters username and password
    And Clicks on login button
    And User should be redirected to the products page
    And user select the product
    Then Cart should contain the added product

  Scenario: Remove Product from the cart
    Given User is on the login page
    When User enters username and password
    And Clicks on login button
    And User should be redirected to the products page
    And user select the product
    And Cart should contain the added product
    And The user click remove button
    Then Cart should not contain the removed product

