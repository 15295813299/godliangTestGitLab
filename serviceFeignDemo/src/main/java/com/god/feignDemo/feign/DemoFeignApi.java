package com.god.feignDemo.feign;

import com.god.common.resp.ResponseCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/14 17:02
 * @description： TODO
 */
@FeignClient(value = "demo")
public interface DemoFeignApi {

    @RequestMapping("/demo/test")
    public ResponseCode demo();

}
