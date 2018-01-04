Feature: Checking Eligibility
  In order to buy bags online,
  As an airline user,
  I want to be able to check bags eligibility sothat I can purchase bags and checkin online

  Scenario: Checking Baggage Eligibility within check in window
    Given Passenger with following reservation wants to check bag online
      | firstName | lastName | origin | destination | departureDate   | journeyType |
      | John      | Smith    | DFW    | HOU         | NOW + 4 Hours | OW          |
    When I check bag eligibility for above passenger
    Then I should be able to see customer is eligible to buy bag for given slice

  Scenario: Checking Baggage Eligibility outside check in window
    Given Passenger with following reservation wants to check bag online
      | firstName | lastName | origin  | destination | departureDate                  | journeyType |
      | Mary      | Smith    | DFW,HOU | HOU,JFK     | NOW + 2 Days, NOW + 2 Days | OW          |
    When I check bag eligibility for above passenger
    Then I should be able to see customer is not eligible to buy bag for given slice

  Scenario: Checking Baggage Eligibility when one or more slice with Other Airline
    Given Passenger with following reservation wants to check bag online
      | firstName | lastName | origin | destination | departureDate | journeyType | Carrier |
      | Danial      | Smith    | DFW    | HOU         | NOW + 1     | OW          | OA      |
    When I check bag eligibility for above passenger
    Then I should be able to see customer is not eligible to buy bag for given slice