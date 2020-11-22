package com.god.demo.controller;

import com.god.common.resp.ResponseCode;
import com.god.demo.service.DemoService;
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
    DemoService demoService;

    @RequestMapping("/test")
    public ResponseCode demo() {
        log.info("===>>>>进入test方法");
        testRedis();
        return ResponseCode.success("test");
    }


    @RequestMapping("/testRedis")
    public ResponseCode testRedis() {
        log.info("===>>>>testRedis");
        String value = demoService.setKey();
        return ResponseCode.success(value);
    }
}
