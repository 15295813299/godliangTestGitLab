package com.god.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName:Score
 * Function:
 * Reason:
 *
 * @Author: zhifeng  Tang
 * @version:
 * @Date: Create in 下午 4:14 2020/11/24 0024
 */
@Data
@Accessors(chain = true)
public class Score implements Serializable {

    private Integer id;
    private Integer cid;
    private Integer score;
}
