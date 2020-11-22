package com.god.demo;

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
@ComponentScan(basePackages={"com.god.common", "com.god.demo"})
public class DemoRun {
    public static void main(String[] args) {
        SpringApplication.run(DemoRun.class,args);
    }
}
