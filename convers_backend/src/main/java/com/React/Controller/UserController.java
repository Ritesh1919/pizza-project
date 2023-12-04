package com.React.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.React.Dto.UserDto;
import com.React.DtoConvert.UserConverter;
import com.React.Entity.User;
import com.React.Service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	UserConverter userconverter;
	
	@PostMapping("/signUp")
	public UserDto signUp(@Valid @RequestBody UserDto uDto) {
		final User user=userconverter.convertDtoToEntity(uDto);
		System.out.println("Sign success");
		return userservice.signUp(user);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserDto uDto) {
		final User user=userconverter.convertDtoToEntity(uDto);
		return userservice.login(user);
	}
	
	@GetMapping("/getAll")
	public String getAll() {
		return "sucess";
	}

}
