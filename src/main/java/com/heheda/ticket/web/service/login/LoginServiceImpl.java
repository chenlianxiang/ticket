package com.heheda.ticket.web.service.login;

import com.alibaba.fastjson.JSON;
import com.heheda.ticket.web.dao.login.LoginDao;
import com.heheda.ticket.web.vo.login.loginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-15 12:51
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;
    @Override
    public int saveLogin(loginVO loginVO) {
        System.out.println(JSON.toJSONString(loginVO));
        return loginDao.saveLogin(loginVO);
    }
}
