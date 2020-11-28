package com.god.user.service.impl;

import com.god.common.model.Login;
import com.god.common.utils.WechatNumberUtil;
import com.god.user.mapper.LoginMapper;
import com.god.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Login)表服务实现类
 *
 * @author makejava
 * @since 2020-11-28 19:53:31
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginDao;

    @Override
    public void addlogin(Login login) {
        String WechatNumber = WechatNumberUtil.GetGenerateString();



    }

}