package com.React.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.React.Dto.PizzaDto;
import com.React.DtoConvert.PizzaConverter;
import com.React.Entity.Pizza;
import com.React.Service.PizzaService;

@RestController
public class PizzaController {
	
	@Autowired
	PizzaService pizzaservice;
	
	@Autowired
	PizzaConverter pizzaconverter;
	
	@PostMapping("/savePizza")
	public PizzaDto savePizza(@RequestBody PizzaDto pDto) {
		final Pizza pizza=pizzaconverter.convertDtoToEntity(pDto);
		
		return pizzaservice.isInsert(pizza);
	}
	
	

}
