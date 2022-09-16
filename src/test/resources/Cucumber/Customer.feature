Feature: Customer
  Scenario: Get a page of customer data
    Given Customer data exists in a database
    And There are no customer filters enabled
    And the customer page offset is small enough
    And The customer page size is large enough
    When I make a request to fetch the customer data
    Then A page of CustomerDTO data is returned