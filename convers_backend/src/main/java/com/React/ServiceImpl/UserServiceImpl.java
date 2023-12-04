package com.React.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.React.Dto.UserDto;
import com.React.DtoConvert.UserConverter;
import com.React.Entity.User;
import com.React.Repository.OrderRepository;
import com.React.Repository.UserRepository;
import com.React.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	UserConverter userconverter;
	
	@Autowired
	OrderRepository orderepo;

	// for sign 
	@Override
	public UserDto signUp(User user ) {
		
		
		
		userrepo.save(user);
		
		UserDto uDto=userconverter.convertEntityToUserDto(user);
		return  uDto;
	}

	
	// for login
	@Override
	public boolean login(User user) {
		
	
	List<User> email=userrepo.findUserByEmail(user.getEmail());
	List<User> password=userrepo.findUserByPassword(user.getPassword());
	
	
	if(!password.isEmpty() && !email.isEmpty() ) {
		//System.out.println("login success");
		return true;
	}
	
	
	return false;
		

	}
}
