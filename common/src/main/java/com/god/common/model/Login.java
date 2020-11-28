package com.god.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Login)实体类
 *
 * @author makejava
 * @since 2020-11-28 19:46:56
 */
@Data
@Accessors(chain = true)
public class Login implements Serializable {
    private static final long serialVersionUID = 958093265339982180L;

    private Integer id;

    private Integer usernamen;

    private String password;

    private String picture;

    private String wechatNumber;

    private Integer state;

    private Integer age;




}