package com.vnpay.learn_springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class RequestParamController {

    // demo param CỤ THỂ trong url. Sử dụng luôn tên của parameter là tên của Request param.
    // Nếu url k theo format thì sẽ bị bad request - 400
    @GetMapping("/requestParam")
    @ResponseBody
    public String requestParamDemo(@RequestParam Integer id) {
        return String.format("requestParamDemo - Request param demo: id = %s", String.valueOf(id));
    }

    // demo param CỤ THỂ trong url. Có chỉ ra tên của param. Nếu url k theo format thì sẽ bị bad request - 400
    @GetMapping("/requestParamV2")
    @ResponseBody
    public String requestParamV2Demo(@RequestParam(name = "id") Integer id, @RequestParam(name = "name") String name) {
        return String.format("requestParamV2Demo - Request param demo: id = %s; name = %s", String.valueOf(id), name);
    }

    // demo bắt tất cả request param trong url thông qua map
    @GetMapping("/requestParamV3")
    @ResponseBody
    public String requestParamV3Demo(@RequestParam Map<String, String> allParams) {
        return "requestParamV3Demo - All parameter: " + allParams.entrySet();
    }

    // demo bắt optional request param trong url
    @GetMapping("/requestParamV4")
    @ResponseBody
    public String requestParamV4Demo(@RequestParam("id") Optional<Integer> id,
                                     @RequestParam("name") Optional<String> name) {
        if (!id.isPresent()) {
            return "requestParamV4Demo: id is not present";
        }

        return "requestParamV4Demo: id = " + id.get()
                + "; name = " + name.get();
    }

    // demo bắt tất cả request param trong url thông qua map
    @GetMapping("/requestParamV5")
    @ResponseBody
    public String requestParamV5Demo(@RequestParam("id") Integer id, @RequestParam("key") List<String> keys) {
        return String.format("requestParamV5Dem: id = %s; keys = %s", id,
                keys.toString());
    }
}
