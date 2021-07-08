package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public class RegularBill extends OrderBill{

	public RegularBill(CafeClerk clerk) {
		super(clerk);
	}
	
	public RegularBill(List<Order> orderList) {
		super(orderList);
	}

	@Override
	public double getTotalBill(List<Order> orderList) {
		double total = 0;
		for(Order i : orderList) {
			total += i.getPrice();
		}
		return total;
	}
	
}
