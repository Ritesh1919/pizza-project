package com.React.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.React.Dto.OrderDto;
import com.React.DtoConvert.OrderConverter;
import com.React.Entity.Order;
import com.React.Entity.User;
import com.React.Repository.OrderRepository;
import com.React.Repository.UserRepository;
import com.React.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	OrderConverter orderconverter;

	@Autowired
	UserRepository userrepo;
	
	@Override
	public OrderDto saveOrder(Order order){
		
		userrepo.save(order.getUser());
		orderrepo.save(order);
		OrderDto oDto=orderconverter.convertEntityToOrderDto(order);
		System.out.println("your order is placed "+order.getAddress());
		return oDto;
	}
	
	// for get all order by specific user

	@Override
	public List<OrderDto> getAllOrderByUser(int user) {
		// TODO Auto-generated method stub
		//List<Order> orders=(List<Order>) orderrepo.findById(user).orElseThrow();
		//List<Order> ords=orderrepo.findById(user);
	List<Order>	orders=orderrepo.findUserByUser(user);
	List<OrderDto> oDtos=new ArrayList<>();
	for(Order order : orders) {
		OrderDto  oDto=orderconverter.convertEntityToOrderDto(order);
		oDtos.add(oDto);
	}
	
		return oDtos ;
	}

	
	// for get all order
	@Override
	public List<OrderDto> getAllOrders() {
		// TODO Auto-generated method stub
	List<Order> orders=	orderrepo.findAll();
	List<OrderDto> oDtos=new ArrayList<>();
	for(Order order : orders) {
		OrderDto  oDto=orderconverter.convertEntityToOrderDto(order);
		oDtos.add(oDto);
	}
		return oDtos;
	}

	
	// update order by specific user
	@Override
	public OrderDto updateOrder(int user,Order order) {
		Order existorder=orderrepo.findById(user).orElseThrow();
		existorder.setPizzatype(order.getPizzatype());
		existorder.setAddress(order.getAddress());
		existorder.setQunatity(order.getQunatity());
		existorder.setStatus(order.getStatus());
		existorder.setTotalprice(order.getTotalprice());
		existorder.setUser(order.getUser());
		orderrepo.save(existorder);
		
		return orderconverter.convertEntityToOrderDto(existorder);
	}
	
	// delete order by using order id

	@Override
	public void deleteById(int orderid) {
		Order order=orderrepo.findById(orderid).orElseThrow();
//		User user=order.getUser();
//		userrepo.delete(user);
//		orderrepo.delete(order);
//		System.out.println("delete success");
		
		User user=order.getUser();
		if (user != null) {
            // Delete associated orders
            List<Order> orders = user.getOrder();
            for (Order order1 : orders) {
                orderrepo.deleteById(order1.getOrderid());
            }

            // Delete user
            userrepo.deleteById(orderid);
            
            System.out.println("delete success"+userrepo.findById(orderid));
	}

	}
}
