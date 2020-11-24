package com.god.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName:Student
 * Function:学生表
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 4:10 2020/11/24 0024
 */
@Data
@Accessors(chain = true)
public class Student implements Serializable {
    private Integer id;
    private String sname;
    private Integer age;
    private Integer sex;

}
