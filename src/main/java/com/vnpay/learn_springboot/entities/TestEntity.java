package com.vnpay.learn_springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "test")
public class TestEntity {

    @Id
    public String id;

    @Field(value = "title")
    public String title;

    @Field(value = "desc")
    public String desc;

    @Field(value = "url")
    public String url;
}
