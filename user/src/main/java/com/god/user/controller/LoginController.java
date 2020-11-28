package com.god.user.controller;

import com.god.user.service.LoginService;
import com.god.user.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Login)表控制层
 *
 * @author makejava
 * @since 2020-11-28 19:53:32
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;


}