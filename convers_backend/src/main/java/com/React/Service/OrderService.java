package com.React.Service;

import java.util.List;

import com.React.Dto.OrderDto;
import com.React.Entity.Order;


public interface OrderService {

	OrderDto saveOrder(Order order);
	
	List<OrderDto> getAllOrderByUser(int user);
	
	List<OrderDto> getAllOrders();
	
	OrderDto updateOrder(int user,Order order);
	
	void deleteById(int order);
}
