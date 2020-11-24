package com.god.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName:course
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:课程表
 * @Date: Create in 下午 3:59 2020/11/24 0024
 */
@Data
@Accessors(chain = true)
public class Course implements Serializable {
    private Integer id;
    private String cname;
    private Integer teacherId;
}
