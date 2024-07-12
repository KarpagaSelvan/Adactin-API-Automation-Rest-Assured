@CityCode
Feature: CityCode module API Automation

  Scenario: Get user Citycode from the application through API
    Given User should add header for to get CityList
    When User should add request body state_Id for get city List
    And User should send "POST" request for CityList end point
    Then User should verify the Status code is 200
    And User should verify the cityList response message matches "Srivilliputtur" and saved cityCode and Verify the Success msg "OK"
