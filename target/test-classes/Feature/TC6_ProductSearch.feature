@ProductSearch
Feature: Change Product Search module API Automation

  Scenario Outline: Verify Product Search on the application through api

    Given User should add header and bearer authorization for accessing productSearch endpoint
    When User should add the request body to search "<Product>"
    And User should send "POST" request for productSearch endpoint
    Then User should verify the Status code is 200
    And User should verify the productSearch response message matches "OK"

    Examples: 
      | Product |
      | nuts    |
