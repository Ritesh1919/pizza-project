package com.React.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.React.Dto.PizzaDto;
import com.React.DtoConvert.PizzaConverter;
import com.React.Entity.Pizza;
import com.React.Repository.PizzaRepository;

import com.React.Service.PizzaService;

@Service
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired
	PizzaRepository pizzarepo;
	
	@Autowired
	PizzaConverter pizzaconvert;

	@Override
	public PizzaDto isInsert(Pizza pizza) {
		// TODO Auto-generated method stub
		pizzarepo.save(pizza);
		PizzaDto pDto=pizzaconvert.convertEntityToOrderDto(pizza);
		return pDto;
	}

}
