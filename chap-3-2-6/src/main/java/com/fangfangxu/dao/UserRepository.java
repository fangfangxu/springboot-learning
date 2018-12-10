package com.fangfangxu.dao;

import com.fangfangxu.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, Long> {
    User findByUsername(String username);

//    User findOne(Long id);

}
