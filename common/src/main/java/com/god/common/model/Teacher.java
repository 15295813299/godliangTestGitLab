package com.god.common.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * ClassName:teacher
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 4:07 2020/11/24 0024
 */
@Data
@Accessors(chain = true)
public class Teacher implements Serializable {

    private Integer id;
    private String tname;
}
