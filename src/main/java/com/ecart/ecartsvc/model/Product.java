package com.ecart.ecartsvc.model;

import java.math.BigDecimal;

public class Product {
	
	private String product;
	
	private String productdescription;
	
	private String color;
	
	private String company;
	
	private String category;
	
	private Integer stock;
	
	private BigDecimal price;
	
	private BigDecimal discount;
	
	
	public Product() {
	}

	/**
	 * @param product
	 * @param productdescription
	 * @param color
	 * @param company
	 * @param category
	 * @param stock
	 * @param price
	 * @param discount
	 */
	public Product(String category, String company, String product,  String color, String productdescription, 
			BigDecimal price, BigDecimal discount, Integer stock) {
		this.product = product;
		this.productdescription = productdescription;
		this.color = color;
		this.company = company;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.discount = discount;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the productdescription
	 */
	public String getProductdescription() {
		return productdescription;
	}

	/**
	 * @param productdescription the productdescription to set
	 */
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [product=" + product + ", productdescription=" + productdescription + ", color=" + color
				+ ", company=" + company + ", category=" + category + ", stock=" + stock + ", price=" + price
				+ ", discount=" + discount + "]";
	}

}
