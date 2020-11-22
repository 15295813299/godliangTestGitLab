package com.god.demo.service.impl;

import com.god.common.utils.RedisUtil;
import com.god.demo.mapper.TestMapper;
import com.god.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/22 11:42
 * @description： TODO
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    TestMapper testMapper;
    @Override
    public String setKey() {
        String key="test";
        redisUtil.set(key,"111",100000);
        Integer test = testMapper.test(111);
        log.info("====>>>数据库查询成功:{}",test);
        return (String) redisUtil.get(key);
    }
}
