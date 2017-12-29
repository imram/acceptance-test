Feature: Selecting one or more Bags
  In order to buy bags online,
  As an airline user,
  I want to be able to select bag(s) and see the price and online savings, if any

  Scenario: Selecting Prepaid bags product to retrieve its prices
    Given Passenger with following reservation wants to select 1 bag and see price
      | firstName | lastName | origin | destination | departureDate   | journeyType |
      | John      | Smith    | DFW    | HOU         | TODAY + 4 Hours | OW          |
    When I retrieve bag offer for above passenger
    Then I should be able to see customer received offers with bag products