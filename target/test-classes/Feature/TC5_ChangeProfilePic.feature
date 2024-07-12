@ChangeProfilePicture
Feature: Change Profile Picture module API Automation

  Scenario: Verify Change Profile Picture to the application through api
    Given User should add header and bearer authorization for accessing changeProfilePicture endpoint
    When User should pass formdata key and filepath
    And User should send "POST" request for changeProfilePic endpoint
    Then User should verify the Status code is 200
    And User should verify the changeProfilePic response message matches "Profile updated Successfully"
