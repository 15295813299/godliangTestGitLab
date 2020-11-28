package com.god.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/28 14:25
 * @description： TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"com.god.common", "com.god.user"})
@MapperScan("com.god.user.mapper")
public class UserRun {
    public static void main(String[] args) {
        SpringApplication.run(UserRun.class,args);
    }
}
