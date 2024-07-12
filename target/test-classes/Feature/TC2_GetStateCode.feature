@StateCode
Feature: StateList module API Automation

  Scenario: Get user Statecode from application through api
   Given User should add header for to get StateList
    When User should send "GET" request for stateList endpoint
    Then User should verify the Status code is 200
    And User should verify the stateList response message matches "Tamil Nadu" and saved stateId and Verify the success msg "OK"
    
    
