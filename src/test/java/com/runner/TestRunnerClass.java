package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see To execute the Project
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = "", stepNotifications = true, publish = true, monochrome = true, plugin = { "pretty",
		"json:\\target\\Output.json" }, snippets = SnippetType.CAMELCASE, dryRun = false, glue = "com.stepdefinition", features = "src\\test\\resources\\Feature")
public class TestRunnerClass extends BaseClass {

	/**
	 * @throws IOException
	 * @see To call the method from Reporting Class to generate JVM Report
	 */
	@AfterClass
	public static void afterClass() throws IOException {

		Reporting.generatesJvmReports(getPropertyFileValue("jsonpath"));

	}

}
