package com.heheda.ticket.web.service.user;

import com.heheda.ticket.web.vo.user.UserVO;

/**
 * @program: ticket
 * @description: 用户接口
 * @author: clx
 * @create: 2019-09-15 12:52
 */
public interface UserService {

    /**
     * 新建用户
     * @param userVO
     * @return
     */
    String saveUser(UserVO userVO);

    /**
     * 查询用户
     * @param userVO
     * @return
     */
    UserVO queryUser(UserVO userVO);

    /**
     * 检查用户名是否唯一
     * @param userVO
     * @return
     */
    Integer checkUserByU_name(UserVO userVO);
}
