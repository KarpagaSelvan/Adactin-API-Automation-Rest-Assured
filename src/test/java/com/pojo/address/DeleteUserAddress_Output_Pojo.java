package com.pojo.address;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response data of Delete User Address endpoint
 *
 */
public class DeleteUserAddress_Output_Pojo {

	private int status;
	private String message;

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

}
