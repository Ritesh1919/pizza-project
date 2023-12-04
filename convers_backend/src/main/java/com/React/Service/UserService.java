package com.React.Service;


import com.React.Dto.UserDto;
import com.React.Entity.User;

public interface UserService {

	UserDto  signUp(User user);
	boolean login(User user);
}
