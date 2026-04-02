Feature: Sample API test

  Scenario: get a user
    Given url 'https://jsonplaceholder.typicode.com/users/1'
    When method GET
    Then status 200
    And match response.name == '#string'
