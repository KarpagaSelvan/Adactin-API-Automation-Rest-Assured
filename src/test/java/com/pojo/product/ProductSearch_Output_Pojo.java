package com.pojo.product;

import java.util.ArrayList;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of Search product endpoint
 *
 */
public class ProductSearch_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<ProductSearchData> data;
	private String currency;

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

	public ArrayList<ProductSearchData> getData() {
		return data;
	}

	public void setData(ArrayList<ProductSearchData> data) {
		this.data = data;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
