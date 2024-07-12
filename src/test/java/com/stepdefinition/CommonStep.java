package com.stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Then;


/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains Common step for all the Scenarios
 *
 */
public class CommonStep {

	/**
	 * 
	 * @param expStatusCode
	 * @see Verification of the Status code for all the Scenarios
	 */
	@Then("User should verify the Status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(int expStatusCode) {

		Assert.assertEquals("Verify the Status Code", expStatusCode, TC1_LoginStep.globalData.getStatusCode());

	}

}
