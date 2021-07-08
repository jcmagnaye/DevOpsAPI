package com.accenture.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.OrderBill;
import com.accenture.ws.impl.RegularBill;
import com.accenture.ws.repository.OrderRepository;

@RestController
public class OrderAndBillingController {

	
	@Autowired
	private OrderRepository orderRepo;
	private CafeClerk clerk;
	
	public OrderAndBillingController(CafeClerk clerk) {
		super();
		this.clerk = clerk;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOrders")
	public List<Order> getOrderList() {
		return (List<Order>) orderRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addOrder")
	public void addOrder(@RequestBody Order order) {
		 orderRepo.save(order);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateOrder")
	public void updateOrder(@RequestBody Order order) {
		Long id = order.getId();
		Order ord = orderRepo.findById(id).get();
		ord.setOrderName(order.getOrderName());
		ord.setPrice(order.getPrice());
		ord.setDiscounted(order.isDiscounted());
		ord.setIsDiscountPercentage(order.getIsDiscountPercentage());
		orderRepo.save(ord);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteOrder/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/regular")
	public double getTotalRegularBill() {
		List<Order> orderList = orderRepo.findAll();
		OrderBill bill = new RegularBill(orderList);
		double total = bill.getTotalBill(orderList);
		return total;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/discounted")
	public double getTotalDiscountedBill() {
		
		List<Order> orderList = orderRepo.findAll();
		OrderBill bill = new DiscountedBill(orderList);
		double total = bill.getTotalBill(orderList);
		return total;
	}
	
	
	
}
