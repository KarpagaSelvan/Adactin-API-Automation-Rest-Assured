package com.pojo.address;

import java.util.ArrayList;

/**
 * Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of State List endpoint
 *
 */
public class GetStateId_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<StateCode> data;

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

	public ArrayList<StateCode> getData() {
		return data;
	}

	public void setData(ArrayList<StateCode> data) {
		this.data = data;
	}

}
