package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.globaldata.GlobalData;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for login endpoint
 *
 */
public class TC1_LoginStep extends BaseClass {

	static GlobalData globalData = new GlobalData();

	Response response;
	String logtoken;

	/**
	 * @see Header Key and Value passing for Login endpoint
	 */
	@Given("User should add header")
	public void userShouldAddHeader() {

		addHeader("accept", "application/json");

	}

	/**
	 * 
	 * @throws IOException
	 * @see Passing the Username and Password for Basic Authentication
	 */
	@When("User should add basic authentication for login")
	public void userShouldAddBasicAuthenticationForLogin() throws IOException {

		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));

	}

	
	/**
	 * 
	 * @param type
	 *@see Passing request with method type and endpoint, getting & setting the status code
	 */
	@When("User should send {string} request for login endpoint")
	public void userShouldSendRequestForLoginEndpoint(String type) {

		response = requestType(type, Endpoints.POSTMANBASICAUTHLOGIN);

		int statusCode = getStatusCode(response);
		globalData.setStatusCode(statusCode);

	}

	/**
	 * 
	 * @param expFirstName
	 * @see Verification of the after login success message
	 */
	@Then("User should verify the login response body firstname present as {string} and get logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstnamePresentAsAndGetLogtokenSaved(String expFirstName) {

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);

		logtoken = login_Output_Pojo.getData().getLogtoken();
		globalData.setLogtoken(logtoken);
		
		String first_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);

		Assert.assertEquals("Verify the First Name", expFirstName, first_name);

	}

}
