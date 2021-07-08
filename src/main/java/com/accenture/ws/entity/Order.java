package com.accenture.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_bill")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="orderName")
	private String orderName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="isDiscounted")
	private boolean isDiscounted;
	
	@Column(name="isDiscountPercentage")
	private double isDiscountPercentage = 5.0;
	
	public Order() {
		//no arg constructor
	}

	public Order(String orderName, double price, boolean isDiscounted) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDiscounted() {
		return isDiscounted;
	}

	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	public double getIsDiscountPercentage() {
		return isDiscountPercentage;
	}

	public void setIsDiscountPercentage(double isDiscountPercentage) {
		this.isDiscountPercentage = isDiscountPercentage;
	}
	
	
}
