package com.hali.spring.usrprofile;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper
{
	User map(UserDTO user);
	UserDTO map(User user);
}
