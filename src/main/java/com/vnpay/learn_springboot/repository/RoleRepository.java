package com.vnpay.learn_springboot.repository;

import com.vnpay.learn_springboot.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
