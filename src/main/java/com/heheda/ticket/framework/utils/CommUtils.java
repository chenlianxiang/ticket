package com.heheda.ticket.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @program: ticket
 * @description: 工具类
 * @author: clx
 * @create: 2019-09-15 00:00
 */
public class CommUtils {
    public static final String format = "yyyy-MM-dd HH:mm:ss";

    public static String getTimeStr() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 返回时间格式字符串
     * @param time
     * @return
     */
    public static String getTimeStr(long time){
        return new SimpleDateFormat(format).format(time);
    }

    /**
     * 返回时间格式字符串
     * @param time
     * @param f  格式化类型
     * @return
     */
    public static String getTimeStr(long time,String f){
        return new SimpleDateFormat(f).format(time);
    }

    /**
     * 创建指定位数的随机字符串
     * @param length 表示生成字符串的长度
     * @return 字符串
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
