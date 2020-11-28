package com.god.user.controller;

import com.god.common.constant.ResponseCodeConstants;
import com.god.common.model.Login;
import com.god.common.resp.ResponseCode;
import com.god.common.utils.WechatNumberUtil;
import com.god.user.service.LoginService;
import com.god.user.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/add")
    public ResponseCode registered(@RequestBody Login login){

        if (login!=null){
            loginService.addlogin(login);
            return ResponseCode.success("注册成功");
        }
        return ResponseCode.error("注册失败");
    }

}