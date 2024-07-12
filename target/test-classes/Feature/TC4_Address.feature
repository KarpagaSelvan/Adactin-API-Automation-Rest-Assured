@Address
Feature: Address module API Automation

  Scenario Outline: Verify add User address to the application through api
    Given User should add header and bearer authorization for accessing address endpoint
    When User should add request body for add new address "<first_Name>","<last_Name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipCode>","<address>" and "<address_Type>"
    And User should send "POST" request for addUserAddress endpoint
    Then User should verify the Status code is 200
    And User should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_Name | last_Name | mobile     | apartment | state | city | country | zipCode | address              | address_Type |
      | Karpaga    | Selvan    | 9962554182 | apartment |    35 | 4241 |     101 |  626110 | 26A,Palanivel Street | Home         |

  Scenario Outline: Verify update address to the application through api
    Given User should add header and bearer authorization for accessing updateAddress endpoint
    When User should add request body to update the address "<address_Id>","<first_Name>","<last_Name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipCode>","<address>" and "<address_Type>"
    And User should send "PUT" request for Update address endpoint
    Then User should verify the Status code is 200
    And User should verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_Id | first_Name | last_Name | mobile     | apartment | state | city | country | zipCode | address              | address_Type |
      |      29829 | Vinoth     | Kumar     | 9962554182 | apartment |    35 | 4241 |     101 |  626110 | 26A,Palanivel Street | Home         |

  Scenario: Verify Get address to the application through api
    Given User should add header and bearer authorization for accessing getAddress endpoint
    When User should send "GET" request for geting all addresses
    Then User should verify the Status code is 200
    And User should verify the getUserAddress response message matches "OK"

  Scenario: Verify delete address to the application through api
    Given User should add header and bearer authorization for accessing deleteAddress endpoint
    When user should add request body for existing address_Id
    And User should send "DELETE" request for deleting the generated Address
    Then User should verify the Status code is 200
    And User should verify the deleteUserAddress response message matches "Address deleted successfully"
