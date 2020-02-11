package com.capgemini.storemanagement.dto;

public class Orders {

	private Integer referenceId;
	
	private Integer orderId;

	private Integer productId;

	private Integer quantity;

	private String location;
	
	private String userId;

	public Orders() {
		super();
	}
	
	public Orders(Integer referenceId, Integer orderId, Integer productId, Integer quantity, String location,
			String userId) {
		super();
		this.referenceId = referenceId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.location = location;
		this.userId = userId;
	}

	public Integer getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Integer resferenceId) {
		this.referenceId = resferenceId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Orders [resferenceId=" + referenceId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", location=" + location + ", userId=" + userId + "]";
	}

}
