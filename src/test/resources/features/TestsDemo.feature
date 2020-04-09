@TC_all
Feature: TestsDemo

  Background:
    Given User on "Account" page for "automationpractice" application
    When User clicks on "Sign In" button on "Login" page
    And User enters "username" as "ConfigValue" on "Login" page
    And User enters "password" as "ConfigValue" on "Login" page
    And User clicks on "Submit" button on "Login" page
    Then "Title" should be "My account - My Store" on "Account" page


  @TC001
  Scenario Outline: TC001: Search
    Given User enters "Search Key" as "<Search Key>" on "Account" page
    And User clicks on "Search" button on "Account" page
    Then "Search Results" should be "<Search Key>" on "Search" page

    Examples:
      | Search Key |
      | Shirt      |

  @TC002
  Scenario: TC002: Add to cart
    Given User enters "Search Key" as "Shirt" on "Account" page
    When User clicks on "Search" button on "Account" page
    And User select "Item" as "Faded Short Sleeve T-shirts" on "Search" page
    And User select "Quantity" as "1" on "Item Description" page
    And User select "Size" as "M" on "Item Description" page
    And User select "Color" as "Orange" on "Item Description" page
    And User clicks on "Add to cart" button on "Item Description" page
    Then "Confirmation" should be "Product successfully added to your shopping cart" on "Cart" page

  @TC003
  Scenario: TC003: Delete from Cart
    Given User enters "Search Key" as "Shirt" on "Account" page
    When User clicks on "Search" button on "Account" page
    And User select "Item" as "Faded Short Sleeve T-shirts" on "Search" page
    And User select "Quantity" as "1" on "Item Description" page
    And User select "Size" as "M" on "Item Description" page
    And User select "Color" as "Orange" on "Item Description" page
    And User clicks on "Add to cart" button on "Item Description" page
    Then "Confirmation" should be "Product successfully added to your shopping cart" on "Cart" page
    And User clicks on "Proceed to checkout" button on "Cart" page
    And User clicks on "Delete" button on "Cart" page
    Then "Warning" should be "Your shopping cart is empty." on "Cart" page

