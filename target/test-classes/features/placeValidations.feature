Feature: Validating place APIs
  Scenario: Validate if place is adding successfully using addplace api
    Given Add Place payload
    When user calls "AddPlaceAPI" with POST http request
    Then API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
