package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class contains reusable methods for a Project
 *
 */
public class BaseClass {

	io.restassured.response.Response response;
	RequestSpecification requestSpec;

	/**
	 * @return String
	 * @see To fetch values from Property file
	 */
	public static String getPropertyFileValue(String key) throws IOException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));

		String value = (String) properties.get(key);
		return value;

	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @see Used to access image formdata on swagger document
	 */
	public void formData(String key, String value) {

		requestSpec = requestSpec.multiPart(key, value);
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @see Used to send Username and Password for Basic Authentication
	 */
	public void basicAuth(String userName, String password) {
		requestSpec.auth().preemptive().basic(userName, password);
	}

	/**
	 * 
	 * @param headers
	 * @see Used to pass Headers when multiple Headers were available
	 */
	public void addHeaders(Headers headers) {

		requestSpec = RestAssured.given().headers(headers);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @see Used to pass Key and Value for a Header
	 */
	public void addHeader(String key, String value) {
		requestSpec = RestAssured.given().header(key, value);

	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @see Used to pass Key and Value for query parameter
	 */
	public void queryParam(String key, String value) {

		requestSpec = requestSpec.queryParam(key, value);

	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @see Used to pass Key and Value for path parameter
	 */
	public void pathParam(String key, String value) {

		requestSpec = requestSpec.pathParam(key, value);

	}

	/**
	 * 
	 * @param body
	 * @see Used to add a request body
	 */
	public void addBody(Object body) {

		requestSpec = requestSpec.body(body);

	}

	/**
	 * 
	 * @param type
	 * @param endPoint
	 * @return Response
	 * @see Used to pass the Method type and Endpoint for various types
	 */
	public Response requestType(String type, String endPoint) {

		switch (type) {
		case "GET":

			response = requestSpec.log().all().get(endPoint);

			break;

		case "POST":

			response = requestSpec.log().all().post(endPoint);

			break;

		case "PUT":

			response = requestSpec.log().all().put(endPoint);

			break;

		case "DELETE":

			response = requestSpec.log().all().delete(endPoint);

			break;

		default:
			break;
		}

		return response;
	}

	/**
	 * 
	 * @param response
	 * @return int
	 * @see Used to fetch a Status Code from response body
	 */
	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;

	}

	/**
	 * 
	 * @param response
	 * @return String
	 * @see Used to fetch responce body as String JSON Object
	 */
	public String getResBodyAsString(Response response) {

		String asString = response.asString();
		return asString;

	}

	/**
	 * 
	 * @param response
	 * @return String
	 * @see Used to fetch responce body as Pretty String JSON Object
	 */
	public String getResBodyAsPrettyString(Response response) {

		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}

}
