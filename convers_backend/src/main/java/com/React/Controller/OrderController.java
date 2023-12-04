package com.React.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.React.Dto.OrderDto;
import com.React.DtoConvert.OrderConverter;
import com.React.Entity.Order;
import com.React.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	OrderConverter orderconverter;
	
	@PostMapping("/saveOrder")
	public OrderDto saveOrder(@RequestBody OrderDto oDto) {
		final Order order=orderconverter.convertDtoToEntity(oDto);
		return  orderservice.saveOrder(order);
	}
	
	@GetMapping("getOrders/{id}")
	public List<OrderDto> getOrders(@PathVariable("id") int userid) {
		return orderservice.getAllOrderByUser(userid);
	}

	
	@GetMapping("/getAllOrders")
	public List<OrderDto> getAllOrders(){
		return orderservice.getAllOrders();
	}
	
	@PutMapping("/updateOrder/{id}")
	public OrderDto updateOrder(@PathVariable("id") int orderid,@RequestBody OrderDto oDto) {
		final Order order=orderconverter.convertDtoToEntity(oDto);
		return  orderservice.updateOrder(orderid,order);
	}
	
	@DeleteMapping("deleteByOrder/{id}")
	public void deleteByOrder(@PathVariable("id") int orderId) {
		 orderservice.deleteById(orderId);
	}
}
