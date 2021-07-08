package com.accenture.ws.order;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.accenture.ws.entity.Order;
import com.accenture.ws.repository.OrderRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrderAndBillingCtrlTest {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Test
	void getOrderList() {
		Order ord = orderRepo.save(new Order("Machiatto", 1.37, true));
		Order ord1 = orderRepo.save(new Order("Water", 1.1, false));
		
		List<Order> orderList = orderRepo.findAll();
		
		Assertions.assertThat(orderList.contains(ord));
		Assertions.assertThat(orderList.contains(ord1));
	}
	
	@Test
	void addOrder() {
		Order ord = orderRepo.save(new Order("Machiatto", 1.36, true));
		
		Assertions.assertThat(ord.getId()).isGreaterThan(0);
	}
	
	@Test
	void updateOrder() {
		Order ord = orderRepo.save(new Order("Decaf", 1.35, true));
		ord.setOrderName("Cafe Americano");
		ord.setPrice(1.75);
		ord.setDiscounted(false);
		Assertions.assertThat(ord.getOrderName()).isEqualTo("Cafe Americano");
	}
	
	@Test
	void deleteOrder() {
		Order ord = orderRepo.save(new Order("Cafe Coco", 2.99, true));
		orderRepo.deleteById(ord.getId());
		
		List<Order> orderList = orderRepo.findAll();
		Assertions.assertThat(!orderList.contains(ord));
	}

}
