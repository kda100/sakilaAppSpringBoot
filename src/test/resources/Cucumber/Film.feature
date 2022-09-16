Feature: Film
  Scenario: Get a page of film data
    Given Film data exists in a database
    And There are no film filters enabled
    And the film page offset is small enough
    And The film page size is large enough
    When I make a request to fetch the film data
    Then A page of FilmDTO data is returned