package com.React.Dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDto {
	
	private int id;
	
	@Size(min = 2,max = 50)
	@NotNull(message = "pizza type is require")
	private String pizzatype;
	
	
	@Size(min = 2,max = 100)
	@NotNull(message = "description is require")
	private String description;
	
	
	@NotNull(message = "description is require")
	private double price;

}
