package com.god.feignDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/14 15:03
 * @description： TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages={"com.god.common", "com.god.feignDemo"})
@MapperScan("com.god.feignDemo.mapper")
public class FeignDemoRun {
    public static void main(String[] args) {
        SpringApplication.run(FeignDemoRun.class,args);
    }
}
