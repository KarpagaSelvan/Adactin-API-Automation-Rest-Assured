@Login
Feature: Login module API Automation

  Scenario: Get user logtoken from login endpoint
    Given User should add header
    When User should add basic authentication for login
    And User should send "POST" request for login endpoint
    Then User should verify the Status code is 200
    Then User should verify the login response body firstname present as "Karpaga" and get logtoken saved
