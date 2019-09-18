package com.heheda.ticket.web.vo.seat;

import lombok.Data;

/**
 * @program: ticket
 * @description: 坐席对象
 * @author: clx
 * @create: 2019-09-07 12:53
 */
@Data
public class seatVO {

    private int seat_id;
    private String seat_type;
    private String seat_name;
    private String seat_code;
}
