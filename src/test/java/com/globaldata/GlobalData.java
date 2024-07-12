package com.globaldata;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used for maintaning the Global datas for an entire Project
 *
 */
public class GlobalData {

	private int statusCode;
	private String logtoken;
	private int stateId;
	private int cityId;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
