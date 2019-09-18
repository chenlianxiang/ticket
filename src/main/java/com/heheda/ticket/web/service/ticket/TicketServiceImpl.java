package com.heheda.ticket.web.service.ticket;

import com.heheda.ticket.web.dao.ticket.TicketDao;
import com.heheda.ticket.web.vo.ticket.ticketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-08 10:48
 */
@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    TicketDao ticketDao;
    @Override
    public List<ticketVO> queryTicket(ticketVO ticketVO) {
        return ticketDao.queryTicket(ticketVO);
    }

    @Override
    public Map<String, String> queryTicket1(ticketVO ticketVO) {
        return ticketDao.queryTicket1(ticketVO);
    }

}
