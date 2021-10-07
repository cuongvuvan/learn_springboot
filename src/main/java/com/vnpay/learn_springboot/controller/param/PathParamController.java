package com.vnpay.learn_springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PathParamController {

    // demo bắt param trong url
    @GetMapping("/demoPathParamV1/user/{id}")
    @ResponseBody
    public String demoPathParamV1(@PathVariable("id") Integer id) {
        return String.format("demoPathParamV1: id = %s", id);
    }

    // demo bắt tất cả param trong url, lưu vào map
    @GetMapping("/demoPathParamV2/user/{id}/name/{name}")
    @ResponseBody
    public String demoPathParamV2(@PathVariable Map<String, String> allParams) {
        return "demoPathParamV2 - All parameter: " + allParams.entrySet();
    }

//    // demo bắt tất cả request param trong url thông qua list
//    @GetMapping("/demoPathParamV3/key/{key}")
//    @ResponseBody
//    public String demoPathParamV3(@RequestParam("key") List<String> keys) {
//        return String.format("requestParamV5Dem: keys = %s", keys.toString());
//    }
}
