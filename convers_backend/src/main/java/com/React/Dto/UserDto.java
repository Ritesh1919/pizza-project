package com.React.Dto;


import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.React.Entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int id;
    
	  
	  @NotNull(message = "Name is required")
		@Size(min = 2, message = "min 2 characters required")
		@Size(max = 20, message = "max 30 characters required")
		@NotBlank
	  private String name;
	  
	  
	  @Size(max = 40, message = "max 40 character required")
	  @Email
	  private String email;
	  
	  
	  @Size(min = 6, message = "min 6 characters required")
	  @Size(max = 20, message = "max 20 character required")
	  private String password;
	  
	  @Size(max = 100, message = "max 100 character required")
	  private String address;
	  
	  @OneToMany
	  private List<Order> order;
}
