package com.god.demo.service.impl;

import com.god.common.utils.RedisUtil;
import com.god.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/22 11:42
 * @description： TODO
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String setKey() {
        String key="test";
        redisUtil.set(key,"111",100000);
        return (String) redisUtil.get(key);
    }
}
