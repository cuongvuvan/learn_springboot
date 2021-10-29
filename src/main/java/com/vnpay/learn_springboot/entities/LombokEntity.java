package com.vnpay.learn_springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LombokEntity {
    private String id;
    private String title;
    @ToString.Exclude private String extraData;
}
