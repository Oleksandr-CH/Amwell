Feature: Create Account

@create
  Scenario:
    Given User on "Account" page for "automationpractice" application
    When User clicks on "Sign In" button on "Login" page
    And User enters "email" as "random" on "Login" page
    And User clicks on "Create an account" button on "Login" page
    And User fill up all information on "Account" page
      | FirstName | LastName | Street          | City    | State | PostalCode | Phone      |password|
      | random    | random   | 123 main street | Fairfax | Virginia    | 20112      | 5712032323 |random  |
    And User clicks on "Register" button on "Account" page
    Then "Title" should be "My account - My Store" on "Account" page




