package com.pojo.address;


/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the request data of Delete User Address endpoint
 *
 */
public class DeleteuserAddress_Input_Pojo {

	private String address_id;

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	/**
	 * @param address_id
	 * @see Constructor for Delete User Address Input Pojo Payload
	 */
	public DeleteuserAddress_Input_Pojo(String address_id) {
		super();
		this.address_id = address_id;
	}
	
	

}
