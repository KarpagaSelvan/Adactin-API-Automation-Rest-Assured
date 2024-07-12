package com.pojo.address;

import java.util.ArrayList;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of City List endpoint
 *
 */
public class GetCityCode_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<CityCode> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<CityCode> getData() {
		return data;
	}

	public void setData(ArrayList<CityCode> data) {
		this.data = data;
	}

}
