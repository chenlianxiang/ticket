package com.heheda.ticket.web.vo;

import lombok.Data;

/**
 * @program: ticket
 * @description:
 * @author: clx
 * @create: 2019-09-12 14:43
 */

@Data
public class ApiRequest<T> {

    private String encrypted;
    private T data;
}
