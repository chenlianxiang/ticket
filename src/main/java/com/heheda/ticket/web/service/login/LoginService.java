package com.heheda.ticket.web.service.login;

import com.heheda.ticket.web.vo.login.loginVO;

public interface LoginService {

    /**
     * 保存登录日志
     * @param loginVO
     * @return
     */
    int saveLogin(loginVO loginVO);
}
