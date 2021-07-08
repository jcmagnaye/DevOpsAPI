package com.accenture.ws.impl;

import java.util.List;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public class DiscountedBill extends OrderBill{

	public DiscountedBill(CafeClerk clerk) {
		super(clerk);
	}
	
	
	public DiscountedBill(List<Order> orderList) {
		super(orderList);
	}

	@Override
	public double getTotalBill(List<Order> orderList) {
		double total = 0;
		for(Order i : orderList) {
			if(i.isDiscounted() == true) {
			total += i.getPrice()*.95;
		}else {
			total += i.getPrice();
		}
			
		}
		return total;
	}

}
