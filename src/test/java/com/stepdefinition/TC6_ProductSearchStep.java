package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.product.ProductSearchPayload;
import com.pojo.product.ProductSearch_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Stepdefinitions for Search Product endpoint
 *
 */
public class TC6_ProductSearchStep extends BaseClass {

	Response response;

	/**
	 * @see Key and Value passing for multiple Headers of Search Product endpoint
	 */
	@Given("User should add header and bearer authorization for accessing productSearch endpoint")
	public void userShouldAddHeaderAndBearerAuthorizationForAccessingProductSearchEndpoint() {

		List<Header> headersList = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		headersList.add(h1);
		headersList.add(h2);

		Headers headers = new Headers(headersList);
		addHeaders(headers);

	}

	/**
	 * 
	 * @param string
	 * @see Adding of request body to access Search Product endpoint
	 */
	@When("User should add the request body to search {string}")
	public void userShouldAddTheRequestBodyToSearch(String text) {

		ProductSearchPayload productSearch = new ProductSearchPayload("nuts");
		addBody(productSearch);

	}

	/**
	 * 
	 * @param type
	 * @see Passing request with method type and endpoint, getting & setting the
	 *      status code
	 */
	@When("User should send {string} request for productSearch endpoint")
	public void userShouldSendRequestForProductSearchEndpoint(String type) {

		response = requestType(type, Endpoints.PRODUCTSEARCH);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);

	}

	/**
	 * 
	 * @param expMsg
	 * @see Verification of the Success message of Search Product endpoint
	 */
	@Then("User should verify the productSearch response message matches {string}")
	public void userShouldVerifyTheProductSearchResponseMessageMatches(String expMsg) {

		ProductSearch_Output_Pojo output_Pojo = response.as(ProductSearch_Output_Pojo.class);
		String message = output_Pojo.getMessage();

		Assert.assertEquals("Verify Msg", expMsg, message);

	}

}
