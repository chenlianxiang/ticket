package com.heheda.ticket.web.service.ticket;

import com.heheda.ticket.web.vo.ticket.ticketVO;

import java.util.List;
import java.util.Map;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-08 10:46
 */
public interface ITicketService {
    /**
     * 查询 车次列表信息
     * @param ticketVO
     * @return
     */
    List<ticketVO> queryTicket(ticketVO ticketVO);


    Map<String,String> queryTicket1(ticketVO ticketVO);
}
