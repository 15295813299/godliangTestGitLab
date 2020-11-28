package com.god.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/14 15:03
 * @description： TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRun {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRun.class,args);
    }
    /**
     * 创建用户唯一标识：使用IP作为用户唯一标识，根据IP进行限流操作
     * @return
     */
    @Bean(name = "iPKeyResolver")
    public KeyResolver userKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                // 获得用户iP
                String ip = exchange.getRequest().getRemoteAddress().getHostString();
                return Mono.just(ip);
            }
        };
    }
}
