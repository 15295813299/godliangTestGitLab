package com.god.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * ClassName:WechatNumberUtil
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 8:32 2020/11/28 0028
 */
@Component
@Slf4j
public class WechatNumberUtil {
    public static String GetGenerateString() {
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int number = random.nextInt(base.length() - 1);
            buffer.append(base.charAt(number));
        }
        return buffer.toString();
    }
}
