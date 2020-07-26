package com.hali.spring.usrprofile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController 
{
	private final UserService userService;
	
	@PostMapping("/user")
	public UserDTO post(UserDTO user)
	{
		return userService.add(user);
	}
	
	
}
