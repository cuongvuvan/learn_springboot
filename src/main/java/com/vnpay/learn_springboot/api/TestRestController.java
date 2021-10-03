package com.vnpay.learn_springboot.api;

import com.vnpay.learn_springboot.entities.TestEntity;
import com.vnpay.learn_springboot.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestRestController {

    @Autowired
    TestRepository testRepository;

    // URL:
    // http://localhost:8080/get_all_test
    // http://localhost:8080/get_all_test.xml
    // http://localhost:8080/get_all_test.json
    @RequestMapping(value = "/get_all_test", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<List<TestEntity>> getEmployees() {
        List<TestEntity> listTestEntity = testRepository.findAll();
        if(listTestEntity.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TestEntity>>(listTestEntity, HttpStatus.OK);
    }
}
