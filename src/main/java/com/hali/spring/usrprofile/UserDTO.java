package com.hali.spring.usrprofile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO 
{	
	private String id;
	
	private String name;	
}
