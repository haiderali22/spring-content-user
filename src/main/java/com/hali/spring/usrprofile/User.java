package com.hali.spring.usrprofile;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
@Builder
public class User 
{
	@Id
	private String id;
	
	private String name;
	
	@ContentId
	private String contentId;

	@ContentLength 
	private long contentLength = 0L;
	
}
