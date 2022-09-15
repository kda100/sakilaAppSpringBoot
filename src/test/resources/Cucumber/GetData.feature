Feature: Get data objects
  Scenario Outline: Verify correct data object is fetched
    Given There is a list a of "<table>"
    And There are no filters enabled
    When A request is made to fetch the "<table>"
    Then A page of "<table>" is returned


    Examples:
    |table |
    |Customers |
    |Films |