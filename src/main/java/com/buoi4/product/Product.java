package com.buoi4.product;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
	private int id;
	@NotBlank(message = "tên sản phẩm không được để trống")
	private String name;
	@Length(min = 0, max= 50, message = "tên hình ảnh không được quá 50 ký tự" )
	private String image;
	@NotNull(message = "giá sản phẩm không được để trống")
	private long price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Product(int id, String name, String image, long price) {

		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
	}
	public Product() {

	}
	
}
