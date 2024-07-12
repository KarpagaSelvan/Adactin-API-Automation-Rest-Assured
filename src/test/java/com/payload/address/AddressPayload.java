package com.payload.address;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.DeleteuserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to create object for all address Scenarios
 *
 */
public class AddressPayload {

	static String addressId;
	static AddressPayload addressPayload = new AddressPayload();

	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param state
	 * @param apartment
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return AddUserAddress_Input_Pojo
	 * @see Payload method for AddUserAddress_Input_Pojo
	 */
	public AddUserAddress_Input_Pojo addUserAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);
		return address_Input_Pojo;

	}

	/**
	 * 
	 * @param addressId
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @return UpdateUserAddress_Input_Pojo
	 * @see Payload method for UpdateUserAddress_Input_Pojo
	 */
	public UpdateUserAddress_Input_Pojo updateUserAddress(String addressId, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {

		UpdateUserAddress_Input_Pojo address_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId, first_name,
				last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return address_Input_Pojo;

	}

	/**
	 * 
	 * @param address_id
	 * @return DeleteuserAddress_Input_Pojo
	 * @see Payload method for DeleteuserAddress_Input_Pojo
	 */
	public DeleteuserAddress_Input_Pojo deleteUserAddress(String address_id) {

		DeleteuserAddress_Input_Pojo address_Input_Pojo = new DeleteuserAddress_Input_Pojo(address_id);
		return address_Input_Pojo;

	}

}
