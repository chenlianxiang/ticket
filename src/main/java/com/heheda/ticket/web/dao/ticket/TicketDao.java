package com.heheda.ticket.web.dao.ticket;

import com.heheda.ticket.web.vo.ticket.ticketVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-07 13:03
 */
@Repository
public interface TicketDao {

    /**
     * 查询 车次列表信息
     * @param ticketVO
     * @return
     */
    List<ticketVO> queryTicket(ticketVO ticketVO);

    Map<String,String> queryTicket1(ticketVO ticketVO);
}
