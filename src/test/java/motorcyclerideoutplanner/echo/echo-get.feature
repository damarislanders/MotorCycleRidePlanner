Feature: sample karate test script

  Background:
    * url baseUrl

  Scenario: Retrieve echo

    Given path '/echo/hello'
    When method get
    Then status 200
    And match response == 'hello'
