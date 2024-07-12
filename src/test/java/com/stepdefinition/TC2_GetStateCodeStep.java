package com.stepdefinition;


import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.GetStateId_Output_Pojo;
import com.pojo.address.StateCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for State List endpoint
 *
 */
public class TC2_GetStateCodeStep extends BaseClass {

	Response response;
	static int stateId1;

	/**
	 * @see Header Key and Value passing for StateList endpoint
	 */
	@Given("User should add header for to get StateList")
	public void userShouldAddHeaderForToGetStateList() {

		addHeader("accept", "application/json");

	}

	/**
	 * 
	 * @param string
	 * @see Passing request with method type and endpoint, getting & setting the status code
	 */
	@When("User should send {string} request for stateList endpoint")
	public void userShouldSendRequestForStateListEndpoint(String type) {

		response = requestType(type, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
	}

	/**
	 * 
	 * @param expStateId
	 * @param expMsg
	 * @see Verification of the Success message of State List endpoint
	 */
	@Then("User should verify the stateList response message matches {string} and saved stateId and Verify the success msg {string}")
	public void userShouldVerifyTheStateListResponseMessageMatchesAndSavedStateIdAndVerifyTheSuccessMsg(String expStateId,
			String expMsg) {

		GetStateId_Output_Pojo getStateId_Output_Pojo = response.as(GetStateId_Output_Pojo.class);

		ArrayList<StateCode> data = getStateId_Output_Pojo.getData();

		for (StateCode stateCode : data) {
			if (stateCode.getName().equals(expStateId)) {

				stateId1 = stateCode.getId();
				TC1_LoginStep.globalData.setStateId(stateId1);

				break;

			}

		}

		String message = getStateId_Output_Pojo.getMessage();
		Assert.assertEquals("Verify OK",expMsg, message);

	}

}
