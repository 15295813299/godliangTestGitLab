package com.god.demo.mapper;


import org.apache.ibatis.annotations.Param;

/**
 * @author GodLiang
 * @version 1.0
 * @date 2020/11/22 14:50
 * @description： TODO
 */
public interface TestMapper {

    public Integer test(@Param("number") Integer number);

}
