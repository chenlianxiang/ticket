package com.heheda.ticket.framework.utils;

import com.heheda.ticket.web.vo.user.UserVO;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @program: ticket
 * @description: MD5密码加密
 * @author: clx
 * @create: 2019-09-15 12:22
 */
public class MD5Utils {

    /**
     * MD5密码加密 采用MD5方法
     * 加密原则  注册的用户名+密码+加密盐  在转Base64
     * @param userVO
     * @return
     */
    public static String EncoderByMD5(UserVO userVO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuffer sb=new StringBuffer();
        sb.append(userVO.getU_name());
        sb.append(userVO.getU_pwd());
        sb.append(userVO.getSalt());
        String md5Pwd=sb.toString();

        //采用MD5加密
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String encode = base64en.encode(md5.digest(md5Pwd.getBytes("utf-8")));
        return encode;
    }
}
