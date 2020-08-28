package com.ecart.ecartsvc.model;

public class Order {
	
	private Integer orderid;
	
	private String product;
	
	private Integer quantity;
	
	public Order() {
	}

	/**
	 * @param orderid
	 * @param product
	 * @param quantity
	 */
	public Order(Integer orderid, String product, Integer quantity) {
		this.orderid = orderid;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the orderid
	 */
	public Integer getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
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
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	

}
