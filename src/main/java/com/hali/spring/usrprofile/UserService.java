package com.hali.spring.usrprofile;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService 
{
	
	private final UserRepository userRepository;
	private final UserImageRepository userImageRepository;
	private final UserMapper userMapper;

	public Mono<UserDTO> add(UserDTO data, FilePart file) 
	{	
		return  userRepository.save(userMapper.map(data)).map( usr -> {
//			userImageRepository.setContent(usr, content)		
			
			return userMapper.map(usr);
		});
	}
	
}
