package com.hali.spring.usrprofile;

import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController 
{
	private final UserService userService;
	
	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<UserDTO> post(@RequestPart("data") Mono<UserDTO>  data,
			@RequestPart("file") Mono<FilePart>  file)
	{
		return userService.add(data,file);
	}
	
	
}
