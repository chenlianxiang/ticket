package com.heheda.ticket.framework.anno;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-12 10:39
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface SecurityParameter {
    /**
     * 入参是否解密，默认解密
     */
    boolean inDecode() default true;

    /**
     * 出参是否加密，默认加密
     */
    boolean outEncode() default true;
}