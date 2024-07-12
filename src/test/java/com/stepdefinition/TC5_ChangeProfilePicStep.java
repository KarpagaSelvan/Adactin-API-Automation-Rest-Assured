package com.stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.profilepic.ChangeProfilePic_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for Change Profile Picture endpoint
 *
 */
public class TC5_ChangeProfilePicStep extends BaseClass {

	Response response;

	/**
	 * @see Key and Value passing for multiple Headers of Change Profile Picture endpoint
	 */
	@Given("User should add header and bearer authorization for accessing changeProfilePicture endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingChangeProfilePictureEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");

		headersList.add(h1);
		headersList.add(h2);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * 
	 * @throws IOException
	 * @see Passing of Key and Value of formdata to upload the new profile pic
	 */
	@When("User should pass formdata key and filepath")
	public void userShouldPassFormdataKeyAndFilepath() throws IOException {

		formData("profile_picture", getPropertyFileValue("filepath"));

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for changeProfilePic endpoint")
	public void userShouldSendRequestForChangeProfilePicEndpoint(String type) {

		response = requestType(type, Endpoints.CHANGEPROFILEPIC);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);

	}

	/**
	 * 
	 * @param expPicMsg
	 * @see Verification of the Success message of Change Profile Picture endpoint
	 */
	@Then("User should verify the changeProfilePic response message matches {string}")
	public void userShouldVerifyTheChangeProfilePicResponseMessageMatches(String expPicMsg) {

		ChangeProfilePic_Pojo changeProfilePic_Pojo = response.as(ChangeProfilePic_Pojo.class);
		String message = changeProfilePic_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Verify the Success Msg", expPicMsg, message);

	}

}
