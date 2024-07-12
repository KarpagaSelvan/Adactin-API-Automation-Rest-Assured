package com.payload.product;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the request body data for Product Search endpoint
 *
 */
public class ProductSearchPayload {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param text
	 * @see Constructor for Product Search Payload
	 */
	public ProductSearchPayload(String text) {
		super();
		this.text = text;
	}
	



}
