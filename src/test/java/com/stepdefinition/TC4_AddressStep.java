package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.address.AddressPayload;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.DeleteuserAddress_Input_Pojo;
import com.pojo.address.GetuserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for addUserAddress, updateuserAddress,
 *      getUserAddress and deleteUserAddress endpoints
 *
 */
public class TC4_AddressStep extends BaseClass {

	static AddressPayload addressPayload = new AddressPayload();
	Response response;
	static String address_id;
	int countryCode;

	/**
	 * @see Key and Value passing for multiple Headers of Add User Address endpoint
	 */
	@Given("User should add header and bearer authorization for accessing address endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingAddressEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		headersList.add(h1);
		headersList.add(h2);
		headersList.add(h3);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @see Adding of request body to access Add User Address endpoint
	 */
	@When("User should add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		countryCode = Integer.parseInt(country);

		AddUserAddress_Input_Pojo address_Input_Pojo = TC3_GetCityCodeStep.addressPayload.addUserAddress(first_name,
				last_name, mobile, apartment, TC1_LoginStep.globalData.getStateId(),
				TC1_LoginStep.globalData.getCityId(), countryCode, zipcode, address, address_type);

		addBody(address_Input_Pojo);

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for addUserAddress endpoint")
	public void userShouldSendRequestForAddUserAddressEndpoint(String type) {

		response = requestType(type, Endpoints.ADDUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);

	}

	/**
	 * 
	 * @param expMsg
	 * @see Verification of the Success msg of Add User Address endpoint
	 */
	@Then("User should verify the addUserAddress response message matches {string}")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatches(String expMsg) {

		AddUserAddress_Output_Pojo address_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);

		int addressId = address_Output_Pojo.getAddress_id();
		address_id = String.valueOf(addressId);
		System.out.println(address_id);
		String message = address_Output_Pojo.getMessage();
		Assert.assertEquals("Verify the Address Success Msg", expMsg, message);

	}

	/**
	 * @see Key and Value passing for multiple Headers of Update User Address
	 *      endpoint
	 */
	@Given("User should add header and bearer authorization for accessing updateAddress endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingUpdateAddressEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		headersList.add(h1);
		headersList.add(h2);
		headersList.add(h3);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * 
	 * @param addressId
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @see Adding of request body to access Update User Address endpoint
	 */
	@When("User should add request body to update the address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldAddRequestBodyToUpdateTheAddressAnd(String address_Id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		countryCode = Integer.parseInt(country);
		int stateCode = Integer.parseInt(state);
		int cityCode = Integer.parseInt(city);

		UpdateUserAddress_Input_Pojo address_Input_Pojo1 = TC3_GetCityCodeStep.addressPayload.updateUserAddress(
				address_Id, first_name, last_name, mobile, apartment, stateCode, cityCode, countryCode, zipcode,
				address, address_type);

		addBody(address_Input_Pojo1);

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for Update address endpoint")
	public void userShouldSendRequestForUpdateAddressEndpoint(String type) {

		response = requestType("PUT", Endpoints.UPDATEUSERADDRESS);

		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);

	}

	/**
	 * 
	 * @param expUpdatedMsg
	 * @see Verification of the Success message of Update User Address endpoint
	 */
	@Then("User should verify the updateUserAddress response message matches {string}")
	public void userShouldVerifyTheUpdateUserAddressResponseMessageMatches(String expUpdatedMsg) {

		UpdateUserAddress_Output_Pojo output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Verify Address updated successfully message", expUpdatedMsg, message);

	}

	/**
	 * @see Key and Value passing for multiple Headers of Get User Address endpoint
	 */
	@Given("User should add header and bearer authorization for accessing getAddress endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingGetAddressEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());

		headersList.add(h1);
		headersList.add(h2);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for geting all addresses")
	public void userShouldSendRequestForGetingAllAddresses(String type) {

		response = requestType(type, Endpoints.GETUSERADDRESS);

		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);

	}

	/**
	 * 
	 * @param expSuccessMsg
	 * @see Verification of the Success message of Get User Address endpoint
	 */
	@Then("User should verify the getUserAddress response message matches {string}")
	public void userShouldVerifyTheGetUserAddressResponseMessageMatches(String expOkMsg) {

		GetuserAddress_Output_Pojo address_Output_Pojo = response.as(GetuserAddress_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Verify the Success Msg", expOkMsg, message);

	}

	/**
	 * @see Key and Value passing for multiple Headers of Delete User Address
	 *      endpoint
	 */
	@Given("User should add header and bearer authorization for accessing deleteAddress endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingDeleteAddressEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		headersList.add(h1);
		headersList.add(h2);
		headersList.add(h3);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * @see Adding of request body to access Delete User Address endpoint
	 */
	@When("user should add request body for existing address_Id")
	public void userShouldAddRequestBodyForExistingAddressId() {

		DeleteuserAddress_Input_Pojo address_Input_Pojo = TC3_GetCityCodeStep.addressPayload
				.deleteUserAddress(address_id);
		addBody(address_Input_Pojo);

	}

	/**
	 * 
	 * @param string
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for deleting the generated Address")
	public void userShouldSendRequestForDeletingTheGeneratedAddress(String string) {
		response = requestType("DELETE", Endpoints.DELETEUSERADDRESS);

		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);
	}

	/**
	 * 
	 * @param expDeletedMsg
	 * @see Verification of the Success msg of Delete User Address endpoint
	 */
	@Then("User should verify the deleteUserAddress response message matches {string}")
	public void userShouldVerifyTheDeleteUserAddressResponseMessageMatches(String expDeletedMsg) {

		DeleteUserAddress_Output_Pojo address_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("verify Address deleted successfully Message", expDeletedMsg, message);

	}

	// 12

}
