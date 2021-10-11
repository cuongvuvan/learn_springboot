package com.vnpay.learn_springboot.controller;

import com.vnpay.learn_springboot.entities.TestEntity;
import com.vnpay.learn_springboot.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private MongoOperations mongoOperations;

//    @RequestMapping("/")
//    public String homePage() {
//        return "index";
//    }
//
//    @ResponseBody
//    @RequestMapping("/getAllTest")
//    public String getAllTestEntities() {
//        List<TestEntity> lstAll = testRepository.findAll();
//        String html = "<!DOCTYPE html>" +
//                "<html lang=\"en\">" +
//                "<head>" +
//                "    <meta charset=\"UTF-8\">" +
//                "    <title>Learn Spring boot</title>" +
//                "</head>" +
//                "<body><h1>Hello Spring boot</h1><ul>";
//        for (TestEntity testEntity : lstAll) {
//            html += "<li>Title: " + testEntity.title+ "; desc: " + testEntity.desc + "; url: " + testEntity.url +  "</li>";
//        }
//
//        html += "</ul></body></html>";
//
//        return html;
//    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable("name") String name) {
//        return "Hello " + name;
//    }
//
//    @GetMapping("/hello2/{name}")
//    public ResponseEntity<String> hello2Name(@PathVariable("name") String name) {
//        return ResponseEntity.status(HttpStatus.OK).body("Hello 2: " + name);
//    }
//
//    @RequestMapping("/login")
//    public ModelAndView login() {
//        ModelAndView mv = new ModelAndView("login");
//        return mv;
//    }
}
