package com.vnpay.learn_springboot.repository;

import com.vnpay.learn_springboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
