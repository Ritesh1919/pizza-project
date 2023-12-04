package com.React.Dto;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.React.Entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	private String pizzatype;
	
	private int qunatity;
	
	private String address;
	
	private String status;
	
	private double totalprice;
}
