package com.pojo.profilepic;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of Change Profile Picture
 *      endpoint
 *
 */
public class ChangeProfilePic_Pojo {

	private int status;
	private String message;
	private ProfilePicData data;
	private int cart_count;

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

	public ProfilePicData getData() {
		return data;
	}

	public void setData(ProfilePicData data) {
		this.data = data;
	}

	public int getCart_count() {
		return cart_count;
	}

	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

}
