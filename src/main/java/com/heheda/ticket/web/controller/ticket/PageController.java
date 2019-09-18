package com.heheda.ticket.web.controller.ticket;

import com.heheda.ticket.framework.anno.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-14 10:54
 */

@Controller
public class PageController {

    @RequestMapping("/test1")
    @JwtIgnore
    public String goTest() {
        return "test";
    }

    @RequestMapping("/register")
    @JwtIgnore
    public String register() {
        return "register";
    }
}
