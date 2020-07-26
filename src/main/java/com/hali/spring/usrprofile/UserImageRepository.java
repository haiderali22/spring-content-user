package com.hali.spring.usrprofile;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserImageRepository extends ReactiveMongoRepository<User,String>
{

}
