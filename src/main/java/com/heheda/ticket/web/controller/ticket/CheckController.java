package com.heheda.ticket.web.controller.ticket;

import com.heheda.ticket.framework.anno.JwtIgnore;
import com.heheda.ticket.framework.anno.SecurityParameter;
import com.heheda.ticket.framework.utils.IPUtils;
import com.heheda.ticket.framework.utils.JwtUtils;
import com.heheda.ticket.framework.utils.MD5Utils;
import com.heheda.ticket.web.service.user.UserServiceImpl;
import com.heheda.ticket.web.vo.jwt.JwtParam;
import com.heheda.ticket.web.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ticket
 * @description: 用户登录、注册、注销控制器
 * @author: clx
 * @create: 2019-09-15 01:11
 */
@RestController
@RequestMapping(value = "api/user")
public class CheckController {

    @Autowired
    JwtParam jwtParam;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "login")
    @JwtIgnore
    @SecurityParameter
    public Map<String,Object> isLoginUser(@RequestBody UserVO userVO){
        String u_name = userVO.getU_name();
        String u_pwd = userVO.getU_pwd();
        String token = JwtUtils.createToken("234", jwtParam);
        Map<String,Object> map=new HashMap<>();
        map.put("isOk",true);
        map.put("token","Bearer"+token);
        return map;
    }

    @RequestMapping(value = "register")
    @JwtIgnore
    @SecurityParameter
    public Map<String,Object> register(@RequestBody UserVO userVO, HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String ip = IPUtils.getIP(request);
        userVO.setLast_ip(ip);
        String salt = userVO.getSalt();
        userVO.setSalt(salt);
        userVO.setU_pwd(MD5Utils.EncoderByMD5(userVO));
        userService.saveUser(userVO);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
       return  map;
    }
}
