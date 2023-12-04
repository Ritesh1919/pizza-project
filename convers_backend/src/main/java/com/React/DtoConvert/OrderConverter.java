package com.React.DtoConvert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.React.Dto.OrderDto;

import com.React.Entity.Order;

@Component
public class OrderConverter {
	// method to covert Dto to entity
		public Order convertDtoToEntity(OrderDto oDto) {
			Order order=new Order();
			if(oDto!=null) {
				BeanUtils.copyProperties(oDto, order);
			}
			return order;
		}
		
		// method to convert entity to Dto
		public OrderDto convertEntityToOrderDto(Order order)
		{
			OrderDto oDto = new OrderDto();
			
			if(order!=null)
			{
				BeanUtils.copyProperties(order, oDto);
				
			}
			return oDto;
		}

}
