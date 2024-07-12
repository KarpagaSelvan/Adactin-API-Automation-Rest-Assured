package com.pojo.address;


/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the request body data for City List endpoint
 *
 */
public class GetCityCode_Input_Pojo {

	private int state_id;

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	/**
	 * @param state_id
	 * @see Constructor for Get City Code Input Pojo Payload
	 */
	public GetCityCode_Input_Pojo(int state_id) {
		super();
		this.state_id = state_id;
	}

}
