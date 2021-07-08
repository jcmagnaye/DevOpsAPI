package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public class OrderBill {

	private List<Order> orderList;
	private CafeClerk clerk;
	
	
	
	public OrderBill(List<Order> orderList, CafeClerk clerk) {
		super();
		this.orderList = orderList;
		this.clerk = clerk;
	}

	public OrderBill(CafeClerk clerk) {
		super();
		this.clerk = clerk;
	}

	public OrderBill(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public CafeClerk getClerk() {
		return clerk;
	}

	public void setClerk(CafeClerk clerk) {
		this.clerk = clerk;
	}
	
	public double getTotalBill(List<Order> orderList) {
		double total = 0;
		for(Order i : orderList) {
			total += i.getPrice();
		}
		return total;
	}
	
}
