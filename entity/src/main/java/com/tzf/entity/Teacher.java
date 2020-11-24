package com.tzf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tname;
}
