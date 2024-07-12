package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.address.AddressPayload;
import com.pojo.address.CityCode;
import com.pojo.address.GetCityCode_Input_Pojo;
import com.pojo.address.GetCityCode_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for City List endpoint
 *
 */
public class TC3_GetCityCodeStep extends BaseClass {

	static AddressPayload addressPayload = new AddressPayload();

	Response response;
	
/**
 * @see Key and Value passing for multiple Headers of CityList endpoint
 */
	@Given("User should add header for to get CityList")
	public void userShouldAddHeaderForToGetCityList() {

		List<Header> listHeaders = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

	}

	/**
	 * @see Adding of request body to access City List endpoint
	 */
	@When("User should add request body state_Id for get city List")
	public void userShouldAddRequestBodyStateIdForGetCityList() {

		GetCityCode_Input_Pojo cityCode_Input_Pojo = new GetCityCode_Input_Pojo(TC1_LoginStep.globalData.getStateId());

		addBody(cityCode_Input_Pojo);

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the status code
	 */
	@When("User should send {string} request for CityList end point")
	public void userShouldSendRequestForCityListEndPoint(String type) {

		response = requestType(type, Endpoints.CITYLIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
		

	}

	/**
	 * 
	 * @param expCityCode
	 * @param expMsg
	 * @see Verification of the Success msg of City List endpoint
	 */
	@Then("User should verify the cityList response message matches {string} and saved cityCode and Verify the Success msg {string}")
	public void userShouldVerifyTheCityListResponseMessageMatchesAndSavedCityCodeAndVerifyTheSuccessMsg(
			String expCityCode, String expMsg) {

		GetCityCode_Output_Pojo cityCode_Output_Pojo = response.as(GetCityCode_Output_Pojo.class);

		ArrayList<CityCode> data = cityCode_Output_Pojo.getData();

		for (CityCode datum : data) {

			if (datum.getName().equals(expCityCode)) {

				int cityId = datum.getId();
				TC1_LoginStep.globalData.setCityId(cityId);

				System.out.println(cityId);

				break;
			}

		}

		String message = cityCode_Output_Pojo.getMessage();
		Assert.assertEquals("Verify OK", expMsg, message);

	}

	// 4

}
