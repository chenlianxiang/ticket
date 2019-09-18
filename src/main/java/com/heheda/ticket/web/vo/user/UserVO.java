package com.heheda.ticket.web.vo.user;

import com.heheda.ticket.framework.utils.CommUtils;

/**
 * @program: ticket
 * @description: 用户对象
 * @author: clx
 * @create: 2019-09-15 01:15
 */
public class UserVO {

    private int u_id;


    private String u_name;

    private String u_pwd;

    private String salt;

    private String last_ip;


    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getSalt() {
        return CommUtils.getRandomString(6);
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



}
