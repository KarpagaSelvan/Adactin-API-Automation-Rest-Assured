package com.pojo.product;

/**
 * @Date 10-10-2022
 * @author Karpaga Selvan M
 * @see Class used to maintain the response body data of Search product endpoint
 *
 */
public class ProductSearchData {
	private String image;
	private String type;
	private String text;
	private int id;
	private int category_id;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


}
