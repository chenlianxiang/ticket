package com.heheda.ticket.web.dao.user;

import com.heheda.ticket.web.vo.user.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 新建用户  返回主键IP
     * @param userVO
     * @return
     */
    int saveUser(UserVO userVO);

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
