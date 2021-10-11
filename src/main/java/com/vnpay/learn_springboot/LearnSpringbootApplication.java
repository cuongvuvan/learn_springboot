package com.vnpay.learn_springboot;

import com.vnpay.learn_springboot.entities.Role;
import com.vnpay.learn_springboot.repository.RoleRepository;
import com.vnpay.learn_springboot.repository.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
////@ComponentScan("com.vnpay.learn_springboot.restful") //to scan packages mentioned
//@EnableMongoRepositories(value = {"com.vnpay.learn_springboot.repository"}) //to activate MongoDB repositories
//@EntityScan("com.vnpay.learn_springboot.entities")
////@EnableJpaRepositories("com.example.repositories")
public class LearnSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringbootApplication.class, args);
    }

//    @Bean
//    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
//        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
//
//        return mongoTemplate;
//    }

//    @Bean
//    CommandLineRunner init(RoleRepository roleRepository) {
//        return args -> {
//            Role adminRole = roleRepository.findByRole("ADMIN");
//            if (adminRole == null) {
//                Role newAdminRole = new Role();
//                newAdminRole.setRole("ADMIN");
//                roleRepository.save(newAdminRole);
//            }
//
//            Role userRole = roleRepository.findByRole("USER");
//            if (userRole == null) {
//                Role newUserRole = new Role();
//                newUserRole.setRole("USER");
//                roleRepository.save(newUserRole);
//            }
//        };
//    }
}
