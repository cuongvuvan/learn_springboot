package com.vnpay.learn_springboot.repository;

import com.vnpay.learn_springboot.entities.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends MongoRepository<TestEntity, String> {
//    TestEntity findByTestEntityID(String id);
//
//    List<TestEntity> getAllTestEntities();

    @Query("{'title': '$title'}")
    TestEntity findTestEntityByTitle(String title);
}
