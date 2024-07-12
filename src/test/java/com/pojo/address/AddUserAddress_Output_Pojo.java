package com.pojo.address;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response data of Add User Address endpoint
 *
 */
public class AddUserAddress_Output_Pojo {

	private int status;
	private String message;
	private int address_id;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

}
