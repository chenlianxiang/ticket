package com.heheda.ticket.web.service.user;

import com.heheda.ticket.web.dao.user.UserDao;
import com.heheda.ticket.web.service.login.LoginServiceImpl;
import com.heheda.ticket.web.vo.login.loginVO;
import com.heheda.ticket.web.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ticket
 * @description: 用户接口实现
 * @author: clx
 * @create: 2019-09-15 12:53
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginServiceImpl loginService;


    @Override
    public String saveUser(UserVO userVO) {
        Integer integer = checkUserByU_name(userVO);
        if (integer>0){
            return "当前用户名已被抢注，请更换";
        }
        int i = userDao.saveUser(userVO);
        if (i>0){
            loginVO loginVO=new loginVO();
            loginVO.setU_id(userVO.getU_id());
            loginVO.setU_name(userVO.getU_name());
            loginVO.setLogin_ip(userVO.getLast_ip());
            loginService.saveLogin(loginVO);
        }
        return "注册成功";
    }

    /**
     * 查询用户对象
     * @param userVO
     * @return
     */
    @Override
    public UserVO queryUser(UserVO userVO) {
        return userDao.queryUser(userVO);
    }

    @Override
    public Integer checkUserByU_name(UserVO userVO) {
        return userDao.checkUserByU_name(userVO);
    }
}
