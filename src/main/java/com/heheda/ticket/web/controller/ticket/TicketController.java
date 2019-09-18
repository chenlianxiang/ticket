package com.heheda.ticket.web.controller.ticket;

import com.alibaba.fastjson.JSON;
import com.heheda.ticket.framework.anno.SecurityParameter;
import com.heheda.ticket.framework.anno.SysLog;
import com.heheda.ticket.web.service.ticket.TicketServiceImpl;
import com.heheda.ticket.web.vo.ticket.ticketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-08 10:49
 */
@RestController
@RequestMapping(value = "api/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @RequestMapping(value = "save")
    @SecurityParameter
    public String save(@RequestBody ticketVO ticketVO){
        return "插入成功";
    }
    @RequestMapping(value = "save2")
    public String save2(){
        return "插入成功";
    }

    @RequestMapping(value = "save1")
    public String save1(@RequestBody ticketVO ticketVO){
        return "成功了";
    }

    /**
     * RSA+AES双重加密测试
     *
     * @return object
     */
    @RequestMapping("/testEncrypt")
    @ResponseBody
    @SecurityParameter
    @SysLog("测试")
    public ticketVO testEncrypt(@RequestBody ticketVO info) {
        System.out.println(info.getFrom_name());
        String content = "上海虹桥";
        info.setFrom_name(content);
        return  info;
    }
}
