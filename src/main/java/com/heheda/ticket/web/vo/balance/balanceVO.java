package com.heheda.ticket.web.vo.balance;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: ticket
 * @description: 剩余座位对象
 * @author: clx
 * @create: 2019-09-07 12:54
 */
@Data
public class balanceVO {
    private int t_id;
    private int ticket_id;
    private int seat_id;
    private BigDecimal ticket_balance;
}
