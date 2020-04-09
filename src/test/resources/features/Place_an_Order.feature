@placeorder
Feature: Place an Order

  Background:
    Given User on "Account" page for "automationpractice" application
    When User clicks on "Sign In" button on "Login" page
    And User enters "username" as "ConfigValue" on "Login" page
    And User enters "password" as "ConfigValue" on "Login" page
    And User clicks on "Submit" button on "Login" page
    Then "Title" should be "My account - My Store" on "Account" page



  Scenario:
    Given User enters "Search Key" as "Shirt" on "Account" page
    When User clicks on "Search" button on "Account" page
    And User select "Item" as "Faded Short Sleeve T-shirts" on "Search" page
    And User select "Quantity" as "1" on "Item Description" page
    And User select "Size" as "M" on "Item Description" page
    And User select "Color" as "Orange" on "Item Description" page
    And User clicks on "Add to cart" button on "Item Description" page
    Then "Confirmation" should be "Product successfully added to your shopping cart" on "Cart" page
    And User clicks on "Proceed to checkout" button on "Item Description" page
    And User clicks on "Proceed to checkout" button on "Cart" page
    And User clicks on "Proceed to checkout" button on "Cart" page
    And User clicks on "Agree" button on "Cart" page
    And User clicks on "Proceed to checkout" button on "Cart" page
    And User clicks on "Pay by check" button on "Cart" page
    And User clicks on "I confirm" button on "Cart" page
    Then "Success" should be "Your order on My Store is complete." on "Cart" page

