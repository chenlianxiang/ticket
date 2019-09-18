package com.heheda.ticket.web.dao.login;

import com.heheda.ticket.web.vo.login.loginVO;
import org.springframework.stereotype.Repository;

/**
 * @program: ticket
 * @description: 登录地点记录
 * @author: clx
 * @create: 2019-09-15 12:07
 */

@Repository
public interface LoginDao {

    /**
     * 保存登录日志
     * @param loginVO
     * @return
     */
    int saveLogin(loginVO loginVO);
}
