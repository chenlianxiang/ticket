package com.heheda.ticket.web.vo.train;

import lombok.Data;

/**
 * @program: ticket
 * @description: 列车对象
 * @author: clx
 * @create: 2019-09-07 12:53
 */
@Data
public class trainVO {
    private int train_id;
    private String train_type;
    private String train_no;
    private String train_simple;
}
