package com.god.common.model;

import java.io.Serializable;
import lombok.Data;

/**
 * login
 * @author 
 */
@Data
public class Login implements Serializable {
    private Integer id;

    private Integer usernamen;

    private String password;

    private String picture;

    private String wechatNumber;

    private Integer state;

    private Integer age;

    private static final long serialVersionUID = 1L;
}