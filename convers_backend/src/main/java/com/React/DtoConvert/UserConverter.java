package com.React.DtoConvert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.React.Dto.UserDto;
import com.React.Entity.User;


@Component
public class UserConverter {

	// method to covert Dto to entity
	public User convertDtoToEntity(UserDto uDto) {
		User user=new User();
		if(uDto!=null) {
			BeanUtils.copyProperties(uDto, user);
		}
		return user;
	}
	
	// method to convert entity to Dto
	public UserDto convertEntityToUserDto(User user)
	{
		UserDto uDto = new UserDto();
		
		if(user!=null)
		{
			BeanUtils.copyProperties(user, uDto);
			
		}
		return uDto;
	}
	
}
