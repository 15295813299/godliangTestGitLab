package com.god.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.god.common.resp.ResponseCode;
import com.god.demo.feign.DemoFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/14 15:38
 * @description： TODO
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    DemoFeignApi feignApi;

    @RequestMapping("/test")
    public ResponseCode demo() {
        log.info("===>>>远程调用demo服务....");
        ResponseCode demo = feignApi.demo();
        log.info("===>>>远程调用demo服务完成,resp:{}", JSONObject.toJSONString(demo));
        return demo;
    }

}
