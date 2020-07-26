package com.hali.spring.usrprofile;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureWebTestClient
public class UserIT
{
	@Autowired
	WebTestClient webTestClient;	
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	public void post() throws Exception
	{
		UserDTO user = UserDTO.builder().name("Myname").build();
		
		
		
		 MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
		    multipartBodyBuilder.part("file", new ClassPathResource("application/tux.jpg"));
		           
		multipartBodyBuilder.part("data", objectMapper.writeValueAsString(user)).
		contentType(MediaType.APPLICATION_JSON);
		    
		webTestClient.post().uri("/user")		
		.contentType(MediaType.MULTIPART_FORM_DATA)
		.bodyValue(multipartBodyBuilder.build())
		.exchange().expectStatus().isCreated().expectBody(UserDTO.class).value( a -> a.getId(), notNullValue());
	}
}
