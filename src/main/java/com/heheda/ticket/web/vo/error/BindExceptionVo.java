package com.heheda.ticket.web.vo.error;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @program: ticket
 * @description: 参数绑定错误
 * @author: clx
 * @create: 2019-09-11 14:02
 */
public class BindExceptionVo extends ErrorVo {

    private BindException bindException;
    private BindingResult result;

    public BindExceptionVo(){}
    public BindExceptionVo(BindException ex,BindingResult result){
        this.bindException=ex;
        this.result=result;
    }

    public BindExceptionVo errorVo(){
        BindExceptionVo bindExceptionVo=new BindExceptionVo();
        List<ObjectError> errors = bindException.getAllErrors();
        String message="";
        bindException.getAllErrors().get(0).getObjectName();
        for (ObjectError error:errors){
            String field = error.getObjectName();

            message= error.getDefaultMessage();
            System.out.println(field+":"+message);
        }
        bindExceptionVo.setMessage(message);
        return bindExceptionVo;
    }
}
