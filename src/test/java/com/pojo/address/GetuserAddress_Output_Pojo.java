package com.pojo.address;

import java.util.ArrayList;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of Get User Address
 *      endpoint
 *
 */
public class GetuserAddress_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<GetUserAddressesData> data;

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

	public ArrayList<GetUserAddressesData> getData() {
		return data;
	}

	public void setData(ArrayList<GetUserAddressesData> data) {
		this.data = data;
	}

}
