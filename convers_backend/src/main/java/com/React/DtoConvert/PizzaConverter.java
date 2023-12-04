package com.React.DtoConvert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.React.Dto.PizzaDto;
import com.React.Entity.Pizza;


@Component
public class PizzaConverter {
	// method to covert Dto to entity
			public Pizza convertDtoToEntity(PizzaDto pDto) {
				Pizza pizza=new Pizza();
				if(pDto!=null) {
					BeanUtils.copyProperties(pDto, pizza);
				}
				return pizza;
			}
			
			// method to convert entity to Dto
			public PizzaDto convertEntityToOrderDto(Pizza pizza)
			{
				PizzaDto pDto = new PizzaDto();
				
				if(pizza!=null)
				{
					BeanUtils.copyProperties(pizza, pDto);
					
				}
				return pDto;
			}
}
